package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;

public class WrongRequest implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

}
