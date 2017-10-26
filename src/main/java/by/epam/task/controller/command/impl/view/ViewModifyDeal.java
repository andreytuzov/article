package by.epam.task.controller.command.impl.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Deal;
import by.epam.task.service.CarService;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

import java.util.Calendar;

public class ViewModifyDeal implements ICommand {

	private static final Logger logger = Logger.getLogger(ViewModifyDeal.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		CarService carService = ServiceFactory.getInstance().getCarService();
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Getting info
		String id = request.getParameter("id");
		String carId = request.getParameter("carId");
		// Data validation
		Boolean isAdmin = (Boolean) request.getSession().getAttribute("admin");
		if (!(isValidInt(id) || isValidInt(carId))) {
			throw new CommandException("Incorrect request data");
		}
		try {
			if (isValidInt(id)) {
				Deal deal = dealService.findOne(Integer.valueOf(id));
				request.setAttribute("deal", deal);
				request.setAttribute("car", deal.getCar());
			} else {
				request.setAttribute("car", carService.findOne(Integer.valueOf(carId)));
			}
		} catch (ServiceException e) {
			throw new CommandException("Error execution the viewModifyDeal command", e);
		}
		return PageResourceManager.getPagePath("page.name.deal.modify-admin");			
		
	}

}
