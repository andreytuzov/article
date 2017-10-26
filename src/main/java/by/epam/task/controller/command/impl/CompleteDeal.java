package by.epam.task.controller.command.impl;

import static by.epam.task.controller.validator.Validator.isValidInt;
import static by.epam.task.controller.validator.Validator.isValidString;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.domain.Deal;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class CompleteDeal implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Get info
		String id = request.getParameter("id");
		// Data validation
		if (!isValidInt(id)) {
			throw new CommandException("Incorrect request data");
		} 		
		try {
			dealService.complete(Integer.valueOf(id));
		} catch (ServiceException e) {
			throw new CommandException("Error execution the completeDeal command", e); 
		}
		return null;
	}

}
