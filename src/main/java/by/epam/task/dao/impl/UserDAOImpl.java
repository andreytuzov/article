package by.epam.task.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.epam.task.dao.UserDAO;
import by.epam.task.dao.connection.ConnectionPool;
import by.epam.task.dao.exception.ConnectionPoolException;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.sql.UserSQL;
import by.epam.task.domain.Role;
import by.epam.task.domain.User;

import static by.epam.task.dao.ColumnLabel.*;

/**
 * Класс, реализующий интерфейс UserDAO
 */
public class UserDAOImpl implements UserDAO {
	
	/** Пул соединений с базой данных */
	private ConnectionPool pool = ConnectionPool.getInstance();

	@Override
	public User findOneByNickname(String nickname) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(UserSQL.SELECT_USER_BY_NICKNAME);
			statement.setString(UserSQL.INDEX_USER_NICKNAME, nickname);
			
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = readFromResultSet(resultSet);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error getting connection", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution sql request", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		return user;
	}
	
	@Override
	public User findOneByNicknameAndPassword(String nickname, String password) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(UserSQL.SELECT_USER_BY_NICKNAME_AND_PASSWORD);
			statement.setString(UserSQL.INDEX_USER_NICKNAME, nickname);
			statement.setString(UserSQL.INDEX_USER_PASSWORD_SELECT, password);
			
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = readFromResultSet(resultSet);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error getting connection", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution sql request", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		return user;
	}	

	@Override
	public List<User> findAll() throws DAOException {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<User> list = null;
		try {
			connection = pool.take();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(UserSQL.SELECT_USERS);
			list = new ArrayList<>();
			User user = null;
			while (resultSet.next()) {
				user = readFromResultSet(resultSet);
				list.add(user);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error getting connection", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution sql request", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		return list;
	}

	@Override
	public int insert(User user, String password) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int id = 0;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(UserSQL.INSERT_USER, Statement.RETURN_GENERATED_KEYS);
			statement.setString(UserSQL.INDEX_USER_NICKNAME, user.getNickname());
			statement.setString(UserSQL.INDEX_USER_PASSWORD, password);
			statement.setInt(UserSQL.INDEX_USER_ROLE_ID, user.getRole().getIndex());
			statement.setString(UserSQL.INDEX_USER_NAME, user.getName());
			statement.setString(UserSQL.INDEX_USER_LASTNAME, user.getLastname());
			statement.setString(UserSQL.INDEX_USER_PHONE, user.getPhone());
			statement.setString(UserSQL.INDEX_USER_EMAIL, user.getEmail());
			statement.setInt(UserSQL.INDEX_USER_DRIVEN_EXPERIENCE, user.getDrivenExperience());
			
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
	public void update(User user) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(UserSQL.UPDATE_USER);
			statement.setString(UserSQL.INDEX_USER_NICKNAME, user.getNickname());
			statement.setInt(UserSQL.INDEX_USER_ROLE_ID, user.getRole().getIndex());
			statement.setString(UserSQL.INDEX_USER_NAME, user.getName());
			statement.setString(UserSQL.INDEX_USER_LASTNAME, user.getLastname());
			statement.setString(UserSQL.INDEX_USER_PHONE, user.getPhone());
			statement.setString(UserSQL.INDEX_USER_EMAIL, user.getEmail());
			statement.setInt(UserSQL.INDEX_USER_DRIVEN_EXPERIENCE, user.getDrivenExperience());
			statement.setInt(UserSQL.INDEX_USER_ID_UPDATE, user.getId());
			
			statement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error getting connection", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution the update method", e);
		} finally {
			pool.closeConnection(connection, statement);
		}
	}
	
	@Override
	public User findOne(int id) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		User user = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(UserSQL.SELECT_USER_BY_ID);
			statement.setInt(UserSQL.INDEX_USER_ID, id);
	
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = readFromResultSet(resultSet);
			}
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error getting connection", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution sql request", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
		return user;
	}
	
	/**
	 * Метод для получения пользователя из объекта результатов выполнения запроса
	 * 
	 * @param resultSet объект результатов выполнения запроса
	 * @return объект пользователя
	 * @throws SQLException возникает при ошибке чтения данных из объекта класса ResultSet
	 */
	private User readFromResultSet(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setId(resultSet.getInt(USER_ID));
		user.setNickname(resultSet.getString(USER_NICKNAME));
		user.setDrivenExperience(resultSet.getInt(USER_DRIVEN_EXPERIENCE));
		user.setEmail(resultSet.getString(USER_EMAIL));
		user.setName(resultSet.getString(USER_NAME));
		user.setLastname(resultSet.getString(USER_LASTNAME));
		user.setPhone(resultSet.getString(USER_PHONE));

		String role = resultSet.getString(ROLE_NAME);
		user.setRole(Role.valueOf(role.toUpperCase()));
		
		return user;
	}

}
