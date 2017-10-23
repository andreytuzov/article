package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class ViewModifyDeal implements ICommand {

	private final static Logger logger = Logger.getLogger(ViewModifyDeal.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		CarService carService = ServiceFactory.getInstance().getCarService();		
		try {
			int carId = Integer.valueOf(request.getParameter("carId"));
			request.setAttribute("car", carService.findOne(carId));
		} catch (ServiceException e) {
			logger.error("Error execution the viewModifyDeal command", e);
		} catch (NumberFormatException e) {
			logger.error("Incorrect number format", e);
		}
		return PageResourceManager.getPagePath("page.name.deal.modify");
	}

}
