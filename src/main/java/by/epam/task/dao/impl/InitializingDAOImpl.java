package by.epam.task.dao.impl;

import java.io.IOException;

import by.epam.task.dao.InitializingDAO;
import by.epam.task.dao.connection.ConnectionPool;
import by.epam.task.dao.exception.ConnectionPoolException;
import by.epam.task.dao.exception.DaoException;

public class InitializingDAOImpl implements InitializingDAO {

	private final ConnectionPool pool = ConnectionPool.getInstance();
	
	@Override
	public void init() throws DaoException {
		try {
			pool.init();
		} catch (ConnectionPoolException e) {
			throw new DaoException("Error completing init method", e);
		}
	}

	@Override
	public void destroy() throws DaoException {
		try {
			pool.close();
		} catch (IOException e) {
			throw new DaoException("Error completing destroy method", e);
		}
	}

}
