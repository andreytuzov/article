package by.epam.task.controller.command.impl;

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
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		return PageResourceManager.getPagePath("page.name.error.notfound");
	}

}
