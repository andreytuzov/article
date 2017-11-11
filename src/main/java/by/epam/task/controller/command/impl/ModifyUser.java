package by.epam.task.controller.command.impl;

import static by.epam.task.controller.validator.Validator.isValidEmail;
import static by.epam.task.controller.validator.Validator.isValidInt;
import static by.epam.task.controller.validator.Validator.isValidPhone;
import static by.epam.task.controller.validator.Validator.isValidString;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.RequestParameter;
import by.epam.task.controller.command.SessionParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.domain.User;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

/**
 * Команда для обработки запроса редактирования данных пользователя  
 */
public class ModifyUser implements ICommand {

	/** Минимальная длина ника пользователя */
	private static final int USER_NICKNAME_MIN_LENGTH = 5;
	/** Максимальная длина ника пользователя */
	private static final int USER_NICKNAME_MAX_LENGTH = 25;
	/** Минимальная длина фамилии пользователя */
	private static final int USER_LASTNAME_MIN_LENGTH = 2;
	/** Максимальная длина фамилии пользователя */
	private static final int USER_LASTNAME_MAX_LENGTH = 30;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		UserService userService = ServiceFactory.getInstance().getUserService();
		// Getting user entered info
		String nickname = request.getParameter(RequestParameter.USER_NICKNAME);
		String name = request.getParameter(RequestParameter.USER_NAME);
		String lastname = request.getParameter(RequestParameter.USER_LASTNAME);
		String drivenExperience = request.getParameter(RequestParameter.USER_DRIVEN_EXPERIENCE);
		String phone = request.getParameter(RequestParameter.USER_PHONE);
		String email = request.getParameter(RequestParameter.USER_EMAIL);
		String accessNickname = (String) request.getSession().getAttribute(SessionParameter.USER_NICKNAME);
		// Data validation
		if (!isValidRequestParameter(nickname, lastname, drivenExperience, phone, email, accessNickname)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			User user = userService.findOneByNickname(nickname);
			user.setDrivenExperience(Integer.valueOf(drivenExperience));
			user.setEmail(email);
			user.setLastname(lastname);
			user.setName(name);
			user.setPhone(phone);
			userService.update(user);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the modifyUser command", e);
		}
	}

	/**
	 * Проверка параметров запроса 
	 * 
	 * @param nickname ник пользователя 
	 * @param lastname фамилия пользователя 
	 * @param drivenExperience опыт вождения 
	 * @param phone телефон пользователя 
	 * @param email почта пользователя 
	 * @param accessNickname ник пользователя с правом редактирования
	 * @return
	 */
	private boolean isValidRequestParameter(String nickname, String lastname, String drivenExperience, String phone,
			String email, String accessNickname) {
		if (!isValidString(nickname, USER_NICKNAME_MIN_LENGTH, USER_NICKNAME_MAX_LENGTH) 
				|| !isValidString(lastname, USER_LASTNAME_MIN_LENGTH, USER_LASTNAME_MAX_LENGTH) || !isValidInt(drivenExperience) 
				|| !isValidPhone(phone) || !isValidEmail(email) || !nickname.equals(accessNickname)) {
			return false;
		}
		return true;
	}
	
}
