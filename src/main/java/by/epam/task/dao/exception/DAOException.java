package by.epam.task.dao.exception;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(String message, Throwable e) {
		super(message, e);
	}
	
}
