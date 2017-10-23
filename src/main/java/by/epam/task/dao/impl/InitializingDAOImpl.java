package by.epam.task.dao.impl;

import java.io.IOException;

import by.epam.task.dao.InitializingDAO;
import by.epam.task.dao.connection.ConnectionPool;
import by.epam.task.dao.exception.ConnectionPoolException;
import by.epam.task.dao.exception.DAOException;

public class InitializingDAOImpl implements InitializingDAO {

	private final ConnectionPool pool = ConnectionPool.getInstance();
	
	@Override
	public void init() throws DAOException {
		try {
			pool.init();
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
