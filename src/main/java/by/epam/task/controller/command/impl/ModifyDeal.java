package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModifyDeal implements ICommand {

	private static final String DATETIME_FORMAT = "yyyy/MM/dd HH:mm";
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Get user entered info
		String id = request.getParameter("id");
		String carId = request.getParameter("carId");
		String nickname = (String) request.getSession().getAttribute("user");
		String strDateFrom = request.getParameter("dateFrom");	
		String strDateTo = request.getParameter("dateTo");
		String comment = request.getParameter("comment");
		String passportNumber = request.getParameter("passportNumber");
		try {
			// Data validation
			if (!isValidInt(carId) || !isValidString(nickname) || !isValidDate(strDateFrom) || !isValidDate(strDateTo)  
					|| !isValidLengthMax(comment, 200) || isValidInt(id) && !dealService.checkUser(nickname, Integer.valueOf(id))
					|| !isValidPassportNumber(passportNumber)) {
				throw new CommandException("Incorrect request data");
			}
			// Date validation
			SimpleDateFormat format = new SimpleDateFormat(DATETIME_FORMAT);
			Date dateFrom = format.parse(strDateFrom);
			Date dateTo = format.parse(strDateTo);
			if (!isValidString(id) && !dealService.checkScheduleCar(Integer.valueOf(carId), dateFrom, dateTo)) {
				throw new CommandException("Busy date");
			}
			int dealId = dealService.modify(isValidString(id) ? Integer.valueOf(id) : 0, nickname, Integer.valueOf(carId), 
					dateFrom, dateTo, comment, passportNumber);
			response.getWriter().append("" + dealId);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the modifyDeal command", e); 
		} catch (ParseException e) {
			throw new CommandException("Incorrect format of dates", e); 
		} catch (IOException e) {
			throw new CommandException("Error execution response function", e);
		}
		return null;
	}

}
