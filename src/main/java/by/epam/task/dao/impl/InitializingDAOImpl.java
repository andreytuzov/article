package by.epam.task.dao.impl;

import java.io.IOException;

import by.epam.task.dao.InitializingDAO;
import by.epam.task.dao.connection.ConnectionPool;
import by.epam.task.dao.connection.manager.DBResourceManager;
import by.epam.task.dao.connection.manager.DBType;
import by.epam.task.dao.exception.ConnectionPoolException;
import by.epam.task.dao.exception.DAOException;

/**
 * Класс, реализующий интерфейс InitializingDAO
 */
public class InitializingDAOImpl implements InitializingDAO {

	/** Пул соединений с базой данных */
	private final ConnectionPool pool = ConnectionPool.getInstance();
	
	@Override
	public void init(DBType dbType) throws DAOException {
		try {
			DBResourceManager dbResourceManager = new DBResourceManager(dbType);
			pool.init(dbResourceManager);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Error completing init method", e);
		}
	}

	@Override
	public void destroy() throws DAOException {
		try {
			pool.close();
		} catch (IOException e) {
			throw new DAOException("Error completing destroy method", e);
		}
	}

}
