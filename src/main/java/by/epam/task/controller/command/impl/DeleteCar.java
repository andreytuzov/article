package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

/**
 * Команда для обработки запроса на удаление автомобиля администратором 
 */
public class DeleteCar implements ICommand {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		CarService carService = ServiceFactory.getInstance().getCarService();
		// Getting info
		String id = request.getParameter("id");
		// Data validation
		if (!isValidInt(id)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			carService.delete(Integer.valueOf(id));
		} catch (ServiceException e) {
			throw new CommandException("Error execution the deleteCar command", e);
		}
		return null;
	}
}
