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
 * Команда для обработки запроса удаления заказа клиентом 
 */
public class DeleteDeal implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Getting info
		String id = request.getParameter(RequestParameter.DEAL_ID);
		String nickname = (String) request.getSession().getAttribute(RequestParameter.USER_NICKNAME);
		try {
			// Data validation
			if (!isValidRequestParameter(id, nickname) || !dealService.checkUser(nickname, Integer.valueOf(id))) {
				throw new CommandException("Incorrect request data");
			}
			dealService.delete(Integer.valueOf(id));
		} catch (ServiceException e) {
			throw new CommandException("Error execution the deleteDeal command", e);
		}
	}
	
	/**
	 * Проверка параметров запроса 
	 * 
	 * @param id идентификатор заказа
	 * @param nickname ник пользователя
	 * @return результат валидации 
	 */
	private boolean isValidRequestParameter(String id, String nickname) {
		if (!isValidInt(id) || !isValidString(nickname)) {
			return false;
		}
		return true;
	}
}
