package by.epam.task.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.epam.task.dao.DamageDAO;
import by.epam.task.dao.connection.ConnectionPool;
import by.epam.task.dao.exception.ConnectionPoolException;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.sql.DamageSQL;
import by.epam.task.domain.Damage;

/**
 * Класс, реализующий интерфейс DamageDAO
 */
public class DamageDAOImpl implements DamageDAO {

	/** Пул соединений с базой данных */
	private final ConnectionPool pool = ConnectionPool.getInstance();

	@Override
	public void insert(Damage damage) throws DAOException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = pool.take();
			statement = connection.prepareStatement(DamageSQL.INSERT_DAMAGE);
			statement.setFloat(DamageSQL.INDEX_DAMAGE_DEAL_ID, damage.getId());
			statement.setFloat(DamageSQL.INDEX_DAMAGE_COST, damage.getCost());
			statement.setString(DamageSQL.INDEX_DAMAGE_DESCRIPTION, damage.getDescription());
			statement.executeUpdate();
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error gettion connection", e);
		} catch (SQLException e) {
			throw new DAOException("Error execution the insert method", e);
		} finally {
			pool.closeConnection(connection, statement, resultSet);
		}
	}

}
