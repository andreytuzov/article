package by.epam.task.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.domain.Car;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

public class ModifyCar implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		CarService carService = ServiceFactory.getInstance().getCarService();
		// Getting user entered info
		String id = request.getParameter("id");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		String volume = request.getParameter("volume");
		String power = request.getParameter("power");
		String prise = request.getParameter("prise");
		String description = request.getParameter("description");
		// Data validation
		if ((isValidString(id) && !isValidInt(id)) || !isValidString(model, 5, 70) || !isValidYear(year) || !isValidFloat(volume) 
				|| !isValidInt(power) || !isValidFloat(prise) || !isValidString(description, 10)) {
			throw new CommandException("Incorrect request data");
		}
		// Creating car object
		Car car = new Car(isValidString(id) ? Integer.valueOf(id) : 0, 
				model, Integer.valueOf(year), Float.valueOf(volume), Integer.valueOf(power), Float.valueOf(prise), description);
		try {
			int carId = carService.modify(car);
			response.getWriter().write("" + carId); 
		} catch (ServiceException e) {
			throw new CommandException("Error executing the ModifyCar command", e);
		} catch (IOException e) {
			throw new CommandException("Error execution response function", e);
		}
		return null;
	}
	
}
