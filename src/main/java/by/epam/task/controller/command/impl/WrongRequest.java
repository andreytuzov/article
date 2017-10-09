package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;

import by.epam.task.controller.command.ICommand;

public class WrongRequest implements ICommand {

	@Override
	public String execute(HttpServletRequest request) {
		return null;
	}

}
