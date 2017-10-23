package by.epam.task.dao.connection;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;

import by.epam.task.dao.connection.manager.DBParameter;
import by.epam.task.dao.connection.manager.DBResourceManager;
import by.epam.task.dao.exception.ConnectionPoolException;

public class ConnectionPool implements Closeable {

	private static final Logger logger = Logger.getLogger(ConnectionPool.class);
	
	private static final ConnectionPool instance = new ConnectionPool();
	
	private BlockingQueue<Connection> freeConnection;
	private BlockingQueue<Connection> busyConnection;
	
	private String username;
	private String password;
	private String driver;
	private String url;
	private int poolsize;

	private ConnectionPool() {
		username = DBResourceManager.getValue(DBParameter.DATABASE_USERNAME);
		password = DBResourceManager.getValue(DBParameter.DATABASE_PASSWORD);
		driver = DBResourceManager.getValue(DBParameter.DATABASE_DRIVER);
		url = DBResourceManager.getValue(DBParameter.DATABASE_URL);

		try {
			poolsize = Integer.parseInt(DBResourceManager.getValue(DBParameter.DATABASE_POOLSIZE));
		} catch (NumberFormatException ex) {
			poolsize = 5;
		}
	}
	
	public static ConnectionPool getInstance() {
		return instance;
	}
	
	/**
	 * Initialization of the connection pool 
	 *  
	 * @throws ConnectionPoolException throw when connection error with database
	 */
	public void init() throws ConnectionPoolException {
		freeConnection = new ArrayBlockingQueue<>(poolsize);
		busyConnection = new ArrayBlockingQueue<>(poolsize);
		try {
			Class.forName(driver);
			for (int i = 0; i < poolsize; i++) {
				freeConnection.add(DriverManager.getConnection(url, username, password));
			}
		} catch (ClassNotFoundException e) {
			throw new ConnectionPoolException("Driver: " + driver + " wasn't found", e);
		} catch (SQLException e) {
			throw new ConnectionPoolException("Error connection: " + url, e);
		}
	}
	
	/**
	 * Close of connection
	 */
	@Override
	public void close() throws IOException {
		List<Connection> listConnection = new ArrayList<>();
		listConnection.addAll(freeConnection);
		listConnection.addAll(busyConnection);
		for (Connection connection : listConnection) {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				logger.error("Error closing connections", e);
			}
		}
	}

	/**
	 * Method for getting connection from pool
	 * 
	 * @return connection's object
	 * @throws ConnectionPoolException throw when error of getting connection
	 */
	public Connection take() throws ConnectionPoolException {
		Connection connection = null;
		try {
			connection = freeConnection.take();
			busyConnection.put(connection);
		} catch (InterruptedException e) {
			throw new ConnectionPoolException("Error getting connection from pool", e);
		}
		return connection;
	}
	
	/**
	 * Method for release a connection
	 * 
	 * @param connection connection
	 * @throws ConnectionPoolException throw when error of putting connection
	 */
	public void free(Connection connection) throws ConnectionPoolException {
		if (connection == null) {
			throw new ConnectionPoolException("connection is null");
		}
		try {
			busyConnection.remove(connection);
			freeConnection.put(connection);
		} catch (InterruptedException e) {
			throw new ConnectionPoolException("Error getting connection from pool", e);
		}
	}
	
	/**
	 * Closing of connection, statementы and resultSet
	 * 
	 * @param connection object for closing 
	 * @param statement object for closing 
	 * @param preparedStatement object for closing 
	 * @param resultSet object for closing 
	 */
	public void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
		if (connection != null) {
			try {
				free(connection);
			} catch (ConnectionPoolException e) {
				logger.error("Error closing connection", e);
			}
		}
		
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				logger.error("Error closing statement", e);
			}
		}
		
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				logger.error("Error closing resultSet", e);
			}
		}
	}
	
	public void closeConnection(Connection connection, Statement statement) {
		closeConnection(connection, statement, null);
	}
}
