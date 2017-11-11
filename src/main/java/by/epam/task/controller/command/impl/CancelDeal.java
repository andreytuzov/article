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
 * Команда для обработки запроса на отмену заказа
 */
public class CancelDeal implements ICommand {

	/** Минимальная длина причины отмены заказа */
	private static final int DEAL_CANCEL_REASON_MIN_LENGTH = 10;
	/** Максимальная длина причины отмены заказа */
	private static final int DEAL_CANCEL_REASON_MAX_LENGTH = 200;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Get user entered info
		String id = request.getParameter(RequestParameter.DEAL_ID);
		String reason = request.getParameter(RequestParameter.DEAL_CANCEL_REASON);
		// Data validation
		if (!isValidRequestParameter(id, reason)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			dealService.cancel(Integer.valueOf(id), reason);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the cancelDeal command", e); 
		}
	}
	
	/**
	 * Проверка параметров запроса
	 * 
	 * @param id идентификатор заказа
	 * @param reason причина отмены заказа
	 * @return результат валидации
	 */
	private boolean isValidRequestParameter(String id, String reason) {
		if (!isValidInt(id) || !isValidString(reason, DEAL_CANCEL_REASON_MIN_LENGTH, DEAL_CANCEL_REASON_MAX_LENGTH)) {
			return false;
		}
		return true;
	}
}
