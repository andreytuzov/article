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
 * Команда для обработки запроса администратора на подтверждение заказа 
 */
public class ConfirmDeal implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Get info
		String id = request.getParameter(RequestParameter.DEAL_ID);
		// Data validation
		if (!isValidRequestParameter(id)) {
			throw new CommandException("Incorrect request data");
		} 		
		try {
			dealService.confirm(Integer.valueOf(id));
		} catch (ServiceException e) {
			throw new CommandException("Error execution the confirmDeal command", e); 
		}
	}
	
	/**
	 * Проверка параметров запроса
	 * 
	 * @param id идентификатор заказа
	 * @return результат валидации
	 */
	private boolean isValidRequestParameter(String id) {
		if (!isValidInt(id)) {
			return false;
		} 		
		return true;
	}

}
