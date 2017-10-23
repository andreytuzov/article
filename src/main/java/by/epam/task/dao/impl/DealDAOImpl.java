package by.epam.task.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import by.epam.task.dao.DealDAO;
import by.epam.task.dao.connection.ConnectionPool;
import by.epam.task.dao.exception.ConnectionPoolException;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.sql.DealSQL;
import by.epam.task.domain.Car;
import by.epam.task.domain.Damage;
import by.epam.task.domain.Deal;
import by.epam.task.domain.DealState;
import by.epam.task.domain.User;

import static by.epam.task.dao.ColumnLabel.*;

public class DealDAOImpl implements DealDAO {

	private final ConnectionPool pool = ConnectionPool.getInstance();
	
	@Override
	public Deal findOneByNickname(String nickname) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Deal deal = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DealSQL.SELECT_DEAL_BY_NICKNAME);
			statement.setString(DealSQL.INDEX_USER_NICKNAME, nickname);
			
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				deal = new Deal();
				deal.setId(resultSet.getInt(DEAL_ID));
				deal.setBill(resultSet.getInt(DEAL_BILL));
				deal.setDateFrom(resultSet.getDate(DEAL_DATE_FROM));
				deal.setDateTo(resultSet.getDate(DEAL_DATE_TO));
				deal.setDescription(resultSet.getString(DEAL_DESCRIPTION));
				
				Car car = new Car();
				car.setId(resultSet.getInt(CAR_ID));
				car.setDescription(resultSet.getString(CAR_DESCRIPTION));
				car.setModel(resultSet.getString(CAR_MODEL));
				car.setPower(resultSet.getInt(CAR_POWER));
				car.setPrise(resultSet.getFloat(CAR_PRISE));
				car.setVolume(resultSet.getFloat(CAR_VOLUME));
				car.setYear(resultSet.getInt(CAR_YEAR));
				deal.setCar(car);
				
				User user = new User();
				user.setId(resultSet.getInt(USER_ID));
				user.setDrivenExperience(resultSet.getInt(USER_DRIVEN_EXPERIENCE));
				user.setEmail(resultSet.getString(USER_EMAIL));
				user.setLastname(resultSet.getString(USER_LASTNAME));
				user.setName(resultSet.getString(USER_NAME));
				user.setNickname(resultSet.getString(USER_NICKNAME));
				user.setPhone(resultSet.getString(USER_PHONE));
				deal.setUser(user);
				
				Damage damage = new Damage();
				damage.setId(resultSet.getInt(DAMAGE_ID));
				damage.setDescription(resultSet.getString(DAMAGE_DESCRIPTION));
				damage.setBill(resultSet.getInt(DAMAGE_BILL));
				deal.setDamage(damage);
				
				deal.setState(DealState.valueOf(resultSet.getString(DEAL_STATE_NAME)));
			}
			
			
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error execution findOneByNickname method", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution sql script", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		return deal;
	}

	@Override
	public List<Deal> findAll() throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Deal> list = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DealSQL.SELECT_DEALS);
			
			resultSet = statement.executeQuery();
			list = new ArrayList<>();
			Deal deal = null;
			if (resultSet.next()) {
				deal = new Deal();
				deal.setId(resultSet.getInt(DEAL_ID));
				deal.setBill(resultSet.getInt(DEAL_BILL));
				deal.setDateFrom(resultSet.getDate(DEAL_DATE_FROM));
				deal.setDateTo(resultSet.getDate(DEAL_DATE_TO));
				deal.setDescription(resultSet.getString(DEAL_DESCRIPTION));
				
				Car car = new Car();
				car.setId(resultSet.getInt(CAR_ID));
				car.setDescription(resultSet.getString(CAR_DESCRIPTION));
				car.setModel(resultSet.getString(CAR_MODEL));
				car.setPower(resultSet.getInt(CAR_POWER));
				car.setPrise(resultSet.getFloat(CAR_PRISE));
				car.setVolume(resultSet.getFloat(CAR_VOLUME));
				car.setYear(resultSet.getInt(CAR_YEAR));
				deal.setCar(car);
				
				User user = new User();
				user.setId(resultSet.getInt(USER_ID));
				user.setDrivenExperience(resultSet.getInt(USER_DRIVEN_EXPERIENCE));
				user.setEmail(resultSet.getString(USER_EMAIL));
				user.setLastname(resultSet.getString(USER_LASTNAME));
				user.setName(resultSet.getString(USER_NAME));
				user.setNickname(resultSet.getString(USER_NICKNAME));
				user.setPhone(resultSet.getString(USER_PHONE));
				deal.setUser(user);
				
				Damage damage = new Damage();
				damage.setId(resultSet.getInt(DAMAGE_ID));
				damage.setDescription(resultSet.getString(DAMAGE_DESCRIPTION));
				damage.setBill(resultSet.getInt(DAMAGE_BILL));
				deal.setDamage(damage);
				
				deal.setState(DealState.valueOf(resultSet.getString(DEAL_STATE_NAME)));
				
				list.add(deal);
			}			
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error execution findOneByNickname method", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution sql script", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		return list;
	}

	@Override
	public int delete(int id) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		Integer count = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DealSQL.DELETE_DEAL);
			statement.setInt(DealSQL.INDEX_DEAL_ID, id);
			count = statement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error getting connection", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution the delete method", e);
		} finally {
			pool.closeConnection(connection, statement);
		}
		return count;
	}

	@Override
	public int insert(Deal deal) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int id = 0;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DealSQL.INSERT_DEAL, Statement.RETURN_GENERATED_KEYS);

			statement.setInt(DealSQL.INDEX_DEAL_BILL, deal.getBill());
			statement.setInt(DealSQL.INDEX_DEAL_CAR_ID, deal.getCar().getId());
			statement.setString(DealSQL.INDEX_DEAL_DESCRIPTION, deal.getDescription());
			statement.setInt(DealSQL.INDEX_DEAL_DEAL_STATE_ID, deal.getState().getIndex());
			statement.setInt(DealSQL.INDEX_DEAL_USER_ID, deal.getUser().getId());

			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
			statement.setString(DealSQL.INDEX_DEAL_DATE_FROM, format.format(deal.getDateFrom().getTime()));
			statement.setString(DealSQL.INDEX_DEAL_DATE_TO, format.format(deal.getDateTo().getTime()));
			
			statement.executeUpdate();
			// Getting id of new item
			resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}	
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error gettion connection", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution the insert method", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		return id;
	}

	@Override
	public int update(Deal deal) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DealSQL.UPDATE_DEAL);
			
			statement.setInt(DealSQL.INDEX_DEAL_BILL, deal.getBill());
			statement.setInt(DealSQL.INDEX_DEAL_CAR_ID, deal.getCar().getId());
			statement.setString(DealSQL.INDEX_DEAL_DESCRIPTION, deal.getDescription());
			statement.setInt(DealSQL.INDEX_DEAL_DEAL_STATE_ID, deal.getState().getIndex());
			statement.setInt(DealSQL.INDEX_DEAL_USER_ID, deal.getUser().getId());

			SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm");
			statement.setString(DealSQL.INDEX_DEAL_DATE_FROM, format.format(deal.getDateFrom().getTime()));
			statement.setString(DealSQL.INDEX_DEAL_DATE_TO, format.format(deal.getDateTo().getTime()));

			statement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error gettion connection", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution the update method", e);
		} finally {
			pool.closeConnection(connection, statement);
		}
		return deal.getId();
	}
	
	
}
