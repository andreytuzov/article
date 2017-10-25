package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ModifyDeal implements ICommand {

	private static final String DATETIME_FORMAT = "DD/MM/YYYY HH:mm";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Get user entered info
		String id = request.getParameter("id");
		String carId = request.getParameter("carId");
		String userId = request.getParameter("userId");
		String dateFrom = request.getParameter("dateFrom");
		String dateTo = request.getParameter("dateTo");
		String description = request.getParameter("description");
		// Data validation
		if (!isValidInt(id) || !isValidInt(carId) || !isValidInt(userId) || !isValidDate(dateFrom) || !isValidDate(dateTo) || !isValidString(description, 10, 200)) {
			throw new CommandException("Incorrect request data");
		}
		SimpleDateFormat format = new SimpleDateFormat(DATETIME_FORMAT);
		try {
			dealService.modify(Integer.valueOf(id), Integer.valueOf(userId), Integer.valueOf(carId), format.parse(dateFrom), format.parse(dateTo), description);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the modifyDeal command", e); 
		} catch (ParseException e) {
			throw new CommandException("Incorrect format of dates", e); 
		}
		return null;
	}

}
