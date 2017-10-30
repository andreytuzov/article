package by.epam.task.controller.command.impl.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Car;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

/**
 * Команда для обработки запроса отображения страницы для редактирования автомобиля  
 */
public class ViewModifyCar implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		CarService carService = ServiceFactory.getInstance().getCarService();
		// Getting info
		String id = request.getParameter("id");
		// Data validation
		if (id != null && !isValidInt(id)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			if (id != null) {
				Car car = carService.findOne(Integer.valueOf(id));
				request.setAttribute("car", car);
			}
		} catch (ServiceException e) {
			throw new CommandException("Error execution the viewModifyCar command", e);
		} 
		return PageResourceManager.getPagePath("page.name.car.modify");
	}
	
}
