package by.epam.task.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;

/**
 * Команда для обработки некорректных запросов 
 */
public class WrongRequest implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		String page = PageResourceManager.getPagePath("page.name.error.notfound");
		try {
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServletException | IOException e) {
			throw new CommandException("Error execution request function", e);
		}
	}

}
