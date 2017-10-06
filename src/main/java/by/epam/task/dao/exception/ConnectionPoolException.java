package by.epam.task.dao.exception;

public class ConnectionPoolException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnectionPoolException(String message) {
		super(message);
	}
	
	public ConnectionPoolException(String message, Throwable e) {
		super(message, e);
	}
	
}
