package by.epam.task.service.exception;

/**
 * Класс исключения, которое может возникнуть во время выполнения методов слоя Service
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String message, Throwable e) {
		super(message, e);
	}
	
}
