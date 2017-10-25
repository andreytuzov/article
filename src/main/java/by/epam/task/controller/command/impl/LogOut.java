package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;

public class LogOut implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			session.invalidate();
		}
		return request.getHeader("referer");
	}

}
