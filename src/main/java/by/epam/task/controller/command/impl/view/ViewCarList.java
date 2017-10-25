package by.epam.task.controller.command.impl.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Car;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class ViewCarList implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		CarService carService = ServiceFactory.getInstance().getCarService();
		try {
			List<Car> listCar = carService.findAll();
			request.setAttribute("listCar", listCar);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the ViewCarList command", e);
		}
		return PageResourceManager.getPagePath("page.name.car.listview");
	}

}
