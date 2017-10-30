package by.epam.task.dao.exception;

/**
 * Класс исключения, которое может возникнуть при выполнении методов слоя DAO
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(String message, Throwable e) {
		super(message, e);
	}
	
}
