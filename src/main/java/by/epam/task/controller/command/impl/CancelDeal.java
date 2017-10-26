package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

public class CancelDeal implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Get user entered info
		String id = request.getParameter("id");
		String reason = request.getParameter("cancelReason");
		// Data validation
		if (!isValidInt(id) || !isValidString(reason, 10, 200)) {
			throw new CommandException("Incorrect request data");
		}
		
		try {
			dealService.cancel(Integer.valueOf(id), reason);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the cancelDeal command", e); 
		}
		return null;
	}

}
