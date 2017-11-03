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

/**
 * Класс для работы с пулом соединений
 */
public class ConnectionPool implements Closeable {

	/** Объект логгера */
	private static final Logger logger = Logger.getLogger(ConnectionPool.class);
	
	/** Экземпляр класса пула соединений*/
	private static final ConnectionPool instance = new ConnectionPool();
	
	/** Коллекция свободных соединений*/
	private BlockingQueue<Connection> freeConnection;
	/** Коллекция занятых соединений */
	private BlockingQueue<Connection> busyConnection;
	
	/**
	 * Метод для получения экземпляра данного класс
	 * 
	 * @return экземпляр данного класса
	 */
	public static ConnectionPool getInstance() {
		return instance;
	}
	
	/**
	 * Метод для инициализации колеекции соединений  
	 * 
	 * @throws ConnectionPoolException возникает при появлении ошибки выполнения метода
	 */
	public void init(DBResourceManager dbResourceManager) throws ConnectionPoolException {
		String username = dbResourceManager.getValue(DBParameter.DATABASE_USERNAME);
		String password = dbResourceManager.getValue(DBParameter.DATABASE_PASSWORD);
		String driver = dbResourceManager.getValue(DBParameter.DATABASE_DRIVER);
		String url = dbResourceManager.getValue(DBParameter.DATABASE_URL);
		int poolsize;
		try {
			poolsize = Integer.parseInt(dbResourceManager.getValue(DBParameter.DATABASE_POOLSIZE));
		} catch (NumberFormatException ex) {
			poolsize = 5;
		}
		
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
	 * Метод для закрытия соединений
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
	 * Метод для получения объекта соединения 
	 * 
	 * @return объект соединения 
	 * @throws ConnectionPoolException возникает при ошибке получения соединения
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
	 * Метод для освобождения соединения
	 * 
	 * @param connection объект соединения
	 * @throws ConnectionPoolException возникает при ошибке освобождение соединения
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
	 * Метод для освобождения ресурсов 
	 * 
	 * @param connection объект соединения
 	 * @param statement объект запроса
	 * @param resultSet объект результатов
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
	
	/**
	 * Метод для освобождения ресурсов
	 * 
	 * @param connection объект соединения
	 * @param statement объект запроса
	 */
	public void closeConnection(Connection connection, Statement statement) {
		closeConnection(connection, statement, null);
	}
}
