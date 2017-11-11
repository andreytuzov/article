package by.epam.task.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.SessionParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;

/**
 * Команда для обработки запроса выхода пользователя 
 */
public class LogOut implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		HttpSession session = request.getSession();
		if (session.getAttribute(SessionParameter.USER_NICKNAME) != null) {
			session.invalidate();
		}
		String page = PageResourceManager.getUrlPath("page.url.car.listview");
		try {
			response.sendRedirect(page);
		} catch (IOException e) {
			throw new CommandException("Error execution the logOut command", e);
		}
	}

}
