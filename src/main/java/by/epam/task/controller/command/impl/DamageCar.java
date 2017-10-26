package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

public class DamageCar implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Getting user entered info
		String id = request.getParameter("id");
		String cost = request.getParameter("damage_cost");
		String description = request.getParameter("damage_description");
		// Data validation
		if (!isValidInt(id) || !isValidFloat(cost) || !isValidString(description, 10, 200)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			dealService.addDamage(Integer.valueOf(id), Float.valueOf(cost), description);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the damageCar command", e); 
		}
		return null;
	}

}
