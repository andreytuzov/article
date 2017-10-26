package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.domain.Deal;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

public class ConfirmDeal implements ICommand {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Get info
		String id = request.getParameter("id");
		String user = (String) request.getSession().getAttribute("user");
		// Data validation
		if (!isValidInt(id) || !isValidString(user)) {
			throw new CommandException("Incorrect request data");
		} 		
		try {
			Deal deal = dealService.findOne(Integer.valueOf(id));
			if (deal.getUser().getNickname().equals(user)) {
				throw new CommandException("User don't have permission to access on this page");
			}
			dealService.confirm(Integer.valueOf(id));
		} catch (ServiceException e) {
			throw new CommandException("Error execution the confirmDeal command", e); 
		}
		return null;
	}

}
