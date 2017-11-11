package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.RequestParameter;
import by.epam.task.controller.command.SessionParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Команда для обработки запроса пользователя на редактироване сделки 
 */
public class ModifyDeal implements ICommand {
	
	/** Строковый формат даты, получаемый из request */
	private static final String DATETIME_FORMAT = "yyyy/MM/dd HH:mm";
	
	private static final int DEAL_COMMENT_MAX_LENGTH = 200;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Get user entered info
		String id = request.getParameter(RequestParameter.DEAL_ID);
		String carId = request.getParameter(RequestParameter.CAR_ID);
		String strDateFrom = request.getParameter(RequestParameter.DEAL_DATE_FROM);	
		String strDateTo = request.getParameter(RequestParameter.DEAL_DATE_TO);
		String comment = request.getParameter(RequestParameter.DEAL_COMMENT);
		String passportNumber = request.getParameter(RequestParameter.DEAL_PASSPORT_NUMBER);
		String nickname = (String) request.getSession().getAttribute(SessionParameter.USER_NICKNAME);
		try {
			// Data validation
			if (!isValidRequestParameter(carId, nickname, strDateFrom, strDateTo, comment, carId, passportNumber)
					|| isValidInt(id) && !dealService.checkUser(nickname, Integer.valueOf(id))) {
				throw new CommandException("Incorrect request data");
			}
			// Date validation
			SimpleDateFormat format = new SimpleDateFormat(DATETIME_FORMAT);
			Date dateFrom = format.parse(strDateFrom);
			Date dateTo = format.parse(strDateTo);
			if (!isValidString(id) && !dealService.checkScheduleCar(Integer.valueOf(carId), dateFrom, dateTo)) {
				throw new CommandException("Busy date");
			}
			int dealId = dealService.modify(isValidString(id) ? Integer.valueOf(id) : 0, nickname, Integer.valueOf(carId), 
					dateFrom, dateTo, comment, passportNumber);
			response.getWriter().append("" + dealId);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the modifyDeal command", e); 
		} catch (ParseException e) {
			throw new CommandException("Incorrect format of dates", e); 
		} catch (IOException e) {
			throw new CommandException("Error execution response function", e);
		}
	}

	/**
	 * Проверка параметров запроса
	 * 
	 * @param carId идентификатор автомобиля
	 * @param nickname ник пользователя
	 * @param strDateFrom дата начала аренды 
	 * @param strDateTo дата окончания аренды
	 * @param comment комментарий к заказу
	 * @param id идентификатор заказа
	 * @param passportNumber номер паспорта
	 * @return результат валидации
	 */
	private boolean isValidRequestParameter(String carId, String nickname, String strDateFrom, String strDateTo,
			String comment, String id, String passportNumber) {
		if (!isValidInt(carId) || !isValidString(nickname) || !isValidDate(strDateFrom) || !isValidDate(strDateTo)  
				|| !isValidLengthMax(comment, DEAL_COMMENT_MAX_LENGTH) || !isValidPassportNumber(passportNumber)) {
			return false;
		}
		return true;
	}
	
}
