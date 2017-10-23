package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Car;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class ViewCar implements ICommand {

	private static final Logger logger = Logger.getLogger(ViewCar.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		CarService carService = serviceFactory.getCarService();		
		try {
			int id = Integer.valueOf(request.getParameter("id")); 
			Car car = carService.findOne(id);
			logger.debug("car = " + car);
			request.setAttribute("car", car);
		} catch (ServiceException e) {
			logger.error("Error execution the ViewCar command", e);
		} catch (NumberFormatException e) {
			logger.error("Incorrect data type", e);
		}
		return PageResourceManager.getPagePath("page.name.car.view");
	}

}
