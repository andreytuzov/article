package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

public class DeleteDeal implements ICommand {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Getting info
		String id = request.getParameter("id");
		String nickname = (String) request.getSession().getAttribute("user");
		try {
			// Data validation
			if (!isValidInt(id) || !isValidString(nickname) || !dealService.checkUser(nickname, Integer.valueOf(id))) {
				throw new CommandException("Incorrect request data");
			}
			dealService.delete(Integer.valueOf(id));
		} catch (ServiceException e) {
			throw new CommandException("Error execution the deleteDeal command", e);
		}
		return null;
	}
}
