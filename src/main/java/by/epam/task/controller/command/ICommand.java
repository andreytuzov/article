package by.epam.task.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.exception.CommandException;

public interface ICommand {
	String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException;
}
