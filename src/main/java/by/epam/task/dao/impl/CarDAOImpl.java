package by.epam.task.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.epam.task.dao.CarDAO;
import by.epam.task.dao.connection.ConnectionPool;
import by.epam.task.dao.exception.ConnectionPoolException;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.sql.CarSQL;
import by.epam.task.domain.Car;

import static by.epam.task.dao.ColumnLabel.*;

/**
 * Класс, реализующий интерфейс CarDAO
 */
public class CarDAOImpl implements CarDAO {

	/** Пул соединений с базой данных */
	private ConnectionPool pool = ConnectionPool.getInstance();

	@Override
	public Car findOne(int id) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Car car = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(CarSQL.SELECT_CAR_BY_ID);
			statement.setInt(CarSQL.INDEX_CAR_ID, id);
			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				car = new Car();
				car.setId(resultSet.getInt(CAR_ID));
				car.setModel(resultSet.getString(CAR_MODEL));
				car.setDescription(resultSet.getString(CAR_DESCRIPTION));
				car.setPower(resultSet.getInt(CAR_POWER));
				car.setPrise(resultSet.getFloat(CAR_PRISE));
				car.setVolume(resultSet.getFloat(CAR_VOLUME));
				car.setYear(resultSet.getInt(CAR_YEAR));
			}

		} catch (SQLException e) {
			throw new DAOException("Error execution the findOne method", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error getting connection", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		return car;
	}

	@Override
	public List<Car> findAll() throws DAOException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Car> list = null;
		try {
			connection = pool.take();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(CarSQL.SELECT_CARS);

			list = new ArrayList<>();
			Car car = null;
			while (resultSet.next()) {
				car = new Car();
				car.setId(resultSet.getInt(CAR_ID));
				car.setModel(resultSet.getString(CAR_MODEL));
				car.setDescription(resultSet.getString(CAR_DESCRIPTION));
				car.setPower(resultSet.getInt(CAR_POWER));
				car.setPrise(resultSet.getFloat(CAR_PRISE));
				car.setVolume(resultSet.getFloat(CAR_VOLUME));
				car.setYear(resultSet.getInt(CAR_YEAR));

				list.add(car);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error getting connection", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution the findAll method", e);
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
			statement = connection.prepareStatement(CarSQL.DELETE_CAR);
			statement.setInt(CarSQL.INDEX_CAR_ID, id);
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
	public int delete(List<Integer> listID) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		int count = 0;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(CarSQL.DELETE_LIST_CARS);
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
	public int insert(Car car) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int id = 0;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(CarSQL.INSERT_CAR, Statement.RETURN_GENERATED_KEYS);

			statement.setString(CarSQL.INDEX_CAR_DESCRIPTION, car.getDescription());
			statement.setString(CarSQL.INDEX_CAR_MODEL, car.getModel());
			statement.setInt(CarSQL.INDEX_CAR_POWER, car.getPower());
			statement.setFloat(CarSQL.INDEX_CAR_PRISE, car.getPrise());
			statement.setFloat(CarSQL.INDEX_CAR_VOLUME, car.getVolume());
			statement.setInt(CarSQL.INDEX_CAR_YEAR, car.getYear());

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
	public int update(Car car) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(CarSQL.UPDATE_CAR);
			
			statement.setString(CarSQL.INDEX_CAR_DESCRIPTION, car.getDescription());
			statement.setString(CarSQL.INDEX_CAR_MODEL, car.getModel());
			statement.setInt(CarSQL.INDEX_CAR_POWER, car.getPower());
			statement.setFloat(CarSQL.INDEX_CAR_PRISE, car.getPrise());
			statement.setFloat(CarSQL.INDEX_CAR_VOLUME, car.getVolume());
			statement.setInt(CarSQL.INDEX_CAR_YEAR, car.getYear());
			statement.setInt(CarSQL.INDEX_CAR_ID_UPDATE, car.getId());
			
			statement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error gettion connection", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution the update method", e);
		} finally {
			pool.closeConnection(connection, statement);
		}
		return car.getId();
	}
}
