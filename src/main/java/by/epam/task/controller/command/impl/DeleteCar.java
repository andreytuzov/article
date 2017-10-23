package by.epam.task.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.ICommand;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class DeleteCar implements ICommand {

	private static final Logger logger = Logger.getLogger(DeleteCar.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		CarService carService = serviceFactory.getCarService();
		try {
			int carId = Integer.valueOf(request.getParameter("id"));
			carService.delete(carId);
			response.sendError(HttpServletResponse.SC_OK);
		} catch (ServiceException e) {
			logger.error("Error execution the deleteCar command", e);
		} catch (NumberFormatException e) {
			logger.error("Incorrect data format", e);
		} catch (IOException e) {
			logger.error("Error setting up status code", e);
		}
		return null;
	}
}
