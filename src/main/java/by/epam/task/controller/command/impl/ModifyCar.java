package by.epam.task.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.mysql.cj.core.util.StringUtils;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Car;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class ModifyCar implements ICommand {

	private static final Logger logger = Logger.getLogger(ModifyCar.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		CarService carService = serviceFactory.getCarService();
		Integer id = 0;
		try {
			String strId = request.getParameter("id");
			if (!StringUtils.isNullOrEmpty(strId)) {
				id = Integer.valueOf(request.getParameter("id"));
			}
			String model = request.getParameter("model");
			int year = Integer.valueOf(request.getParameter("year"));
			float volume = Float.valueOf(request.getParameter("volume"));
			int power = Integer.valueOf(request.getParameter("power"));
			float prise = Float.valueOf(request.getParameter("prise"));
			String description = request.getParameter("description");
			
			Car car = new Car();
			car.setId(id);
			car.setModel(model);
			car.setYear(year);
			car.setVolume(volume);
			car.setPower(power);
			car.setPrise(prise);
			car.setDescription(description);
			
			id = carService.saveOrUpdate(car);
			
			response.getWriter().write("" + id); 
			return null;
		} catch (ServiceException e) {
			logger.error("Error executing the ModifyCar command", e);
		} catch (NumberFormatException e) {
			logger.error("Incorrect data type", e);
		} catch (IOException e) {
			logger.error("Error execution response function", e);
		}
		try {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} catch (IOException e) {
			logger.error("Error execution response function", e);
		}
		return null;
	}
	
}
