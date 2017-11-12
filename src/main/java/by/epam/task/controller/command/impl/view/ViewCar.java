package by.epam.task.controller.command.impl.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.RequestParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Car;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

import java.io.IOException;

/**
 * Команда для обработки запроса отображения автомобиля 
 */
public class ViewCar implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		CarService carService = ServiceFactory.getInstance().getCarService();		
		// Getting user entered info
		String id = request.getParameter(RequestParameter.CAR_ID);
		// Data validation
		if (!isValidRequestParameter(id)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			Car car = carService.findOne(Integer.valueOf(id));
			request.setAttribute(RequestParameter.CAR_OBJECT, car);
			String page = PageResourceManager.getPagePath("page.name.car.view");
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the ViewCar command", e);
		} catch (ServletException | IOException e) {
			throw new CommandException("Error execution request function", e);
		} 
	}
	
	/**
	 * Проверка параметров запроса
	 * 
	 * @param id идентификатор автомобиля
	 * @return результат валидации
	 */
	private boolean isValidRequestParameter(String id) {
		if (!isValidInt(id)) {
			return false;
		}
		return true;
	}

}
