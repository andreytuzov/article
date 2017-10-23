package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.manager.PageResourceManager;

public class ViewLogIn implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return PageResourceManager.getPagePath("page.name.user.login");
	}

}
