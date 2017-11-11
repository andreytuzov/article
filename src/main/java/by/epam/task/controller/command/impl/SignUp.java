package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.RequestParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.domain.Role;
import by.epam.task.domain.User;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

/**
 * Команда для обработки запроса регистрации пользователя 
 */
public class SignUp implements ICommand {

	/** Минимальная длина ника пользователя */
	private static final int USER_NICKNAME_MIN_LENGTH = 5;
	/** Максимальная длина ника пользователя */
	private static final int USER_NICKNAME_MAX_LENGTH = 25;
	/** Минимальная длина пароля пользователя */
	private static final int USER_PASSWORD_MIN_LENGTH = 5;
	/** Максимальная длина пароля пользователя */
	private static final int USER_PASSWORD_MAX_LENGTH = 25;
	/** Минимальная длина фамилии пользователя */
	private static final int USER_LASTNAME_MIN_LENGTH = 2;
	/** Максимальная длина фамилии пользователя */
	private static final int USER_LASTNAME_MAX_LENGTH = 30;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		UserService userService = ServiceFactory.getInstance().getUserService();
		// Getting user entered info
		String nickname = request.getParameter(RequestParameter.USER_NICKNAME);
		String password = request.getParameter(RequestParameter.USER_PASSWORD);
		String name = request.getParameter(RequestParameter.USER_NAME);
		String lastname = request.getParameter(RequestParameter.USER_LASTNAME);
		String drivenExperience = request.getParameter(RequestParameter.USER_DRIVEN_EXPERIENCE);
		String phone = request.getParameter(RequestParameter.USER_PHONE);
		String email = request.getParameter(RequestParameter.USER_EMAIL);
		// Data validation
		if (!isValidRequestParameter(nickname, password, lastname, drivenExperience, phone, email)) {
			throw new CommandException("Incorrect request data");
		}
		User user = new User(0, nickname, name, lastname, 
				phone, email, Integer.valueOf(drivenExperience), Role.CUSTOMER);
		try {
			userService.add(user, password);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the signUp command", e);
		}
	}
	
	/**
	 * Проверка параметров запроса
	 * 
	 * @param nickname ник пользователя
	 * @param password пароль пользователя
	 * @param lastname фамилия пользователя 
	 * @param drivenExperience опыт вождения пользователя 
	 * @param phone телефон пользователя
	 * @param email почта пользователя
	 * @return результат валидации
	 */
	private boolean isValidRequestParameter(String nickname, String password, String lastname,
			String drivenExperience, String phone, String email) {
		if (!isValidString(nickname, USER_NICKNAME_MIN_LENGTH, USER_NICKNAME_MAX_LENGTH) 
				|| !isValidString(password, USER_PASSWORD_MIN_LENGTH, USER_PASSWORD_MAX_LENGTH) 
				|| !isValidString(lastname, USER_LASTNAME_MIN_LENGTH, USER_LASTNAME_MAX_LENGTH) 
				|| !isValidInt(drivenExperience) || !isValidPhone(phone) || !isValidEmail(email)) {
			return false;
		}
		return true;
	}

}
