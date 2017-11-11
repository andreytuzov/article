package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.RequestParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

/**
 * Команда для обработки запроса администратора на добавление повреждения автомобиля 
 */
public class DamageCar implements ICommand {

	/** Минимальная длина описания повреждения автомобиля */
	private static final int DAMAGE_DESCRIPTION_MIN_LENGTH = 10;
	/** Максимальная длина описания повреждения автомобиля */
	private static final int DAMAGE_DESCRIPTION_MAX_LENGTH = 200;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Getting user entered info
		String id = request.getParameter(RequestParameter.DAMAGE_ID);
		String cost = request.getParameter(RequestParameter.DAMAGE_COST);
		String description = request.getParameter(RequestParameter.DAMAGE_DESCRIPTION);
		// Data validation
		if (!isValidRequestParameter(id, cost, description)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			dealService.addDamage(Integer.valueOf(id), Float.valueOf(cost), description);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the damageCar command", e); 
		}
	}
	
	/**
	 * Проверка параметров запроса
	 * 
	 * @param id идентификатор заказа
	 * @param cost стоимость ремонта автомобиля
	 * @param description описание автомобиля
	 * @return результат валидации
	 */
	private boolean isValidRequestParameter(String id, String cost, String description) {
		if (!isValidInt(id) || !isValidFloat(cost) || !isValidString(description, DAMAGE_DESCRIPTION_MIN_LENGTH, DAMAGE_DESCRIPTION_MAX_LENGTH)) {
			return false;
		}
		return true;
	}

}
