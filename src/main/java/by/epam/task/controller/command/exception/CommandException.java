package by.epam.task.controller.command.exception;

/**
 * Класс исключения, которое может возникнуть во время обработки команды
 */
public class CommandException extends Exception {

	private static final long serialVersionUID = 1L;

	public CommandException(String message) {
		super(message);
	}
	
	public CommandException(String message, Throwable e) {
		super(message, e);
	}
	
}
