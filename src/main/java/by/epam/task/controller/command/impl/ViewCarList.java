package by.epam.task.controller.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Car;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class ViewCarList implements ICommand {

	private static final Logger logger = Logger.getLogger(ViewCarList.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		CarService carService = serviceFactory.getCarService();
		try {
			List<Car> listCar = carService.findAll();
			request.setAttribute("listCar", listCar);
		} catch (ServiceException e) {
			logger.error("Error execution the ViewCarList command", e);
		}
		return PageResourceManager.getPagePath("page.name.car.listview");
	}

}
