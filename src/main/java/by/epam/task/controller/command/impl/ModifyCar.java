package by.epam.task.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.RequestParameter;
import by.epam.task.controller.command.SessionParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.domain.Car;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

/**
 * Команда для обработки запроса администратора на обновление автомобиля 
 */
public class ModifyCar implements ICommand {

	/** Минимальная длина строки модели автомобиля */
	private static final int CAR_MODEL_MIN_LENGTH = 5;
	/** Максимальная длина строки модели автомобиля */
	private static final int CAR_MODEL_MAX_LENGTH = 70;
	/** Минимальная длина строки описания автомобиля */
	private static final int CAR_DESCRIPTION_MIN_LENGTH = 10;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		CarService carService = ServiceFactory.getInstance().getCarService();
		// Getting user entered info
		String id = request.getParameter(RequestParameter.CAR_ID);
		String model = request.getParameter(RequestParameter.CAR_MODEL);
		String year = request.getParameter(RequestParameter.CAR_YEAR);
		String volume = request.getParameter(RequestParameter.CAR_VOLUME);
		String power = request.getParameter(RequestParameter.CAR_POWER);
		String prise = request.getParameter(RequestParameter.CAR_PRISE);
		String description = request.getParameter(RequestParameter.CAR_DESCRIPTION);
		Boolean isAdmin = (Boolean) request.getSession().getAttribute(SessionParameter.ROLE_IS_ADMIN);
		if (isAdmin == null) {
			isAdmin = false;
		}
		// Data validation
		if (!isValidRequestParameter(isAdmin, id, model, year, volume, power, prise, description)) {
			throw new CommandException("Incorrect request data");
		}
		// Creating car object
		Car car = new Car(isValidString(id) ? Integer.valueOf(id) : 0, 
				model, Integer.valueOf(year), Float.valueOf(volume), Integer.valueOf(power), Float.valueOf(prise), description);
		try {
			int carId = carService.modify(car);
			response.getWriter().write("" + carId); 
		} catch (ServiceException e) {
			throw new CommandException("Error executing the ModifyCar command", e);
		} catch (IOException e) {
			throw new CommandException("Error execution response function", e);
		}
	}

	/**
	 * Проверка параметров запроса
	 * 
	 * @param isAdmin true - если роль администратора 
	 * @param id идентификатор автомобиля
	 * @param model модель автомобиля 
	 * @param year год выпуска автомобиля
	 * @param volume объем двигателя автомобиля
	 * @param power мощность автомобиля 
	 * @param prise цена автомобиля 
	 * @param description описание автомобиля 
	 * @return результат валидации
	 */
	private boolean isValidRequestParameter(boolean isAdmin, String id, String model, String year, String volume, 
			String power, String prise, String description) {
		if (!isAdmin || (isValidString(id) && !isValidInt(id)) || !isValidString(model, CAR_MODEL_MIN_LENGTH, CAR_MODEL_MAX_LENGTH) 
				|| !isValidYear(year) || !isValidFloat(volume) 
				|| !isValidInt(power) || !isValidFloat(prise) || !isValidString(description, CAR_DESCRIPTION_MIN_LENGTH)) {
			return false;
		}
		return true;
	}
	
}
