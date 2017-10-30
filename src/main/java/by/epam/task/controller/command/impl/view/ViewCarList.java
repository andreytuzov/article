package by.epam.task.controller.command.impl.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

/**
 * Команда для обработки запроса отображения списка автомобилей  
 */
public class ViewCarList implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		CarService carService = ServiceFactory.getInstance().getCarService();
		try {
			request.setAttribute("listCar", carService.findAll());
		} catch (ServiceException e) {
			throw new CommandException("Error execution the ViewCarList command", e);
		}
		return PageResourceManager.getPagePath("page.name.car.listview");
	}

}
