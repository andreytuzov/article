package by.epam.task.controller.command.impl.view;

import static by.epam.task.controller.validator.Validator.isValidInt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class ViewModifyDeal implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		CarService carService = ServiceFactory.getInstance().getCarService();
		// Getting info
		String carId = request.getParameter("carId");
		// Data validation
		if (!isValidInt(carId)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			request.setAttribute("car", carService.findOne(Integer.valueOf(carId)));
		} catch (ServiceException e) {
			throw new CommandException("Error execution the viewModifyDeal command", e);
		}
		return PageResourceManager.getPagePath("page.name.deal.modify");
	}

}
