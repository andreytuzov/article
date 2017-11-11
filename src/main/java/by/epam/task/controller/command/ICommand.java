package by.epam.task.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.exception.CommandException;

/**
 * Интерфейс команды 
 */
public interface ICommand {
	/**
	 * Метод для обработки запроса пользователя 
	 * 
	 * @param request объект запроса
	 * @param response объект ответа
	 * @throws CommandException если произошла ошибка во время выполнения команды
	 */
	void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
