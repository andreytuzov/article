package by.epam.task.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.epam.task.dao.DamageDAO;
import by.epam.task.dao.connection.ConnectionPool;
import by.epam.task.dao.exception.ConnectionPoolException;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.sql.DamageSQL;
import by.epam.task.domain.Damage;

public class DamageDAOImpl implements DamageDAO {

	private final ConnectionPool pool = ConnectionPool.getInstance();
	
	@Override
	public int delete(int id) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		Integer count = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DamageSQL.DELETE_DAMAGE);
			statement.setInt(DamageSQL.INDEX_DAMAGE_DEAL_ID, id);
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
	public int insert(Damage damage) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int id = 0;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DamageSQL.INSERT_DAMAGE, Statement.RETURN_GENERATED_KEYS);

			statement.setFloat(DamageSQL.INDEX_DAMAGE_BILL, damage.getCost());
			statement.setString(DamageSQL.INDEX_DAMAGE_DESCRIPTION, damage.getDescription());
			
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
	public int update(Damage damage) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DamageSQL.UPDATE_DAMAGE);
			
			statement.setFloat(DamageSQL.INDEX_DAMAGE_BILL, damage.getCost());
			statement.setString(DamageSQL.INDEX_DAMAGE_DESCRIPTION, damage.getDescription());

			statement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error gettion connection", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution the update method", e);
		} finally {
			pool.closeConnection(connection, statement);
		}
		return damage.getId();
	}

}
