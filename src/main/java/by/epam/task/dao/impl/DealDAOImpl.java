package by.epam.task.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	
	private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm";
	
	@Override
	public Deal findOne(int id) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Deal deal = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DealSQL.SELECT_DEAL_BY_ID);
			statement.setInt(DealSQL.INDEX_DEAL_ID, id);
			
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				deal = readFromResultSet(resultSet);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error execution findOne method", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution sql script", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		return deal;
	}
	
	@Override
	public List<Deal> findAllByCarAfterNow(int id) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Deal deal = null;
		List<Deal> list = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DealSQL.SELECT_DEAL_BY_CAR_AFTER_NOW);
			statement.setInt(DealSQL.INDEX_DEAL_CAR_ID, id);
			
			resultSet = statement.executeQuery();
			list = new ArrayList<>();
			while (resultSet.next()) {
				deal = readFromResultSet(resultSet);
				list.add(deal);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error execution findAllAfterNow method", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution sql script", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		return list;
	}

	@Override
	public List<Deal> findAllByCarBetweenDate(int id, Date dateFrom, Date dateTo) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Deal deal = null;
		List<Deal> list = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DealSQL.SELECT_DEAL_BY_CAR_BETWEEN_DATE);
			
			SimpleDateFormat format = new SimpleDateFormat(DATETIME_FORMAT);
			statement.setInt(DealSQL.INDEX_DEAL_CAR_ID, id);
			statement.setString(DealSQL.INDEX_DEAL_DATE_FROM, format.format(dateFrom.getTime()));
			statement.setString(DealSQL.INDEX_DEAL_DATE_TO, format.format(dateTo.getTime()));
			
			resultSet = statement.executeQuery();
			list = new ArrayList<>();
			while (resultSet.next()) {
				deal = readFromResultSet(resultSet);
				list.add(deal);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error execution findAllAfterNow method", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution sql script", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		return list;
	}
	
	@Override
	public List<Deal> findAllByNickname(String nickname) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Deal deal = null;
		List<Deal> list = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DealSQL.SELECT_DEAL_BY_NICKNAME);
			statement.setString(DealSQL.INDEX_USER_NICKNAME, nickname);
			
			resultSet = statement.executeQuery();
			list = new ArrayList<>();
			while (resultSet.next()) {
				deal = readFromResultSet(resultSet);
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
	public List<Deal> findAllByDealState(DealState dealState) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Deal> list = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DealSQL.SELECT_DEAL_BY_DEALSTATE);
			statement.setInt(DealSQL.INDEX_DEAL_DEAL_STATE_ID_SELECT, dealState.getIndex());
			
			resultSet = statement.executeQuery();
			list = new ArrayList<>();
			Deal deal = null;
			while (resultSet.next()) {
				deal = readFromResultSet(resultSet);
				if (deal.getState() == dealState) {					
					list.add(deal);
				}
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
			while (resultSet.next()) {
				deal = readFromResultSet(resultSet);
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

			statement.setFloat(DealSQL.INDEX_DEAL_COST, deal.getCost());
			statement.setInt(DealSQL.INDEX_DEAL_CAR_ID, deal.getCar().getId());
			statement.setString(DealSQL.INDEX_DEAL_DESCRIPTION, deal.getComment());
			statement.setInt(DealSQL.INDEX_DEAL_DEAL_STATE_ID, deal.getState().getIndex());
			statement.setInt(DealSQL.INDEX_DEAL_USER_ID, deal.getUser().getId());
			statement.setString(DealSQL.INDEX_DEAL_CANCEL_REASON, deal.getCancelReason());
			statement.setString(DealSQL.INDEX_DEAL_PASSWORD_NUMBER, deal.getPassportNumber());
			
			SimpleDateFormat format = new SimpleDateFormat(DATETIME_FORMAT);
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
			
			statement.setInt(DealSQL.INDEX_DEAL_ID_UPDATE, deal.getId());
			statement.setFloat(DealSQL.INDEX_DEAL_COST, deal.getCost());
			statement.setInt(DealSQL.INDEX_DEAL_CAR_ID, deal.getCar().getId());
			statement.setString(DealSQL.INDEX_DEAL_DESCRIPTION, deal.getComment());
			statement.setInt(DealSQL.INDEX_DEAL_DEAL_STATE_ID, deal.getState().getIndex());
			statement.setInt(DealSQL.INDEX_DEAL_USER_ID, deal.getUser().getId());
			statement.setString(DealSQL.INDEX_DEAL_CANCEL_REASON, deal.getCancelReason());
			statement.setString(DealSQL.INDEX_DEAL_PASSWORD_NUMBER, deal.getPassportNumber());

			SimpleDateFormat format = new SimpleDateFormat(DATETIME_FORMAT);
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
	
	private Deal readFromResultSet(ResultSet resultSet) throws SQLException, DAOException {
		Deal deal = new Deal();
		deal.setId(resultSet.getInt(DEAL_ID));
		deal.setCost(resultSet.getInt(DEAL_COST));
		// Convert date 
		SimpleDateFormat format = new SimpleDateFormat(DATETIME_FORMAT);
		try {
			deal.setDateFrom(format.parse(resultSet.getString(DEAL_DATE_FROM)));
			deal.setDateTo(format.parse(resultSet.getString(DEAL_DATE_TO)));
		} catch (ParseException e) {
			throw new DAOException("Incorrect data format into database", e);
		}
		deal.setComment(resultSet.getString(DEAL_COMMENT));
		deal.setCancelReason(resultSet.getString(DEAL_CANCEL_REASON));
		deal.setPassportNumber(resultSet.getString(DEAL_PASSPORT_NUMBER));
		
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
		damage.setCost(resultSet.getInt(DAMAGE_COST));
		deal.setDamage(damage);
		
		// logic separation of the state
		DealState dealState = DealState.valueOf(resultSet.getString(DEAL_STATE_NAME).toUpperCase());
		Date now = new Date();
		if (dealState == DealState.PAID && now.getTime() > deal.getDateFrom().getTime()) {
			if (now.getTime() < deal.getDateTo().getTime()) {
				dealState = DealState.ACTIVE;
			} else {
				dealState = DealState.FINISHED;
			}
		}
		deal.setState(dealState);
		return deal;
	}
}
