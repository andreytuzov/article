package by.epam.task.controller.command.exception;

public class AccessCommandException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccessCommandException(String message) {
		super(message);
	}
	
	public AccessCommandException(String message, Throwable e) {
		super(message, e);
	}
	
}
