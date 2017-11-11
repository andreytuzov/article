package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.RequestParameter;
import by.epam.task.controller.command.SessionParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Role;
import by.epam.task.domain.User;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

import java.io.IOException;

/**
 * Команда для обработки аутентификации пользователя 
 */
public class LogIn implements ICommand {
		
	/** Минимальная длина ника пользователя */
	private static final int USER_NICKNAME_MIN_LENGTH = 5;
	/** Максимальная длина ника пользователя */
	private static final int USER_NICKNAME_MAX_LENGTH = 25;
	/** Минимальная длина пароля пользователя */
	private static final int USER_PASSWORD_MIN_LENGTH = 5;
	/** Максимальная длина пароля пользователя */
	private static final int USER_PASSWORD_MAX_LENGTH = 25;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		UserService userService = ServiceFactory.getInstance().getUserService();
		// Getting user entered info
		String nickname = request.getParameter(RequestParameter.USER_NICKNAME);
		String password = request.getParameter(RequestParameter.USER_PASSWORD);
		// Data validation
		if (!isValidRequestParameter(nickname, password)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			User user = userService.findOneByNicknameAndPassword(nickname, password);
			// Setting session attributes
			request.getSession().setAttribute(SessionParameter.USER_NICKNAME, nickname);
			request.getSession().setAttribute(SessionParameter.ROLE_NAME, user.getRole());
			if (user.getRole() == Role.ADMIN) {					
				request.getSession().setAttribute(SessionParameter.ROLE_IS_ADMIN, true);
			}
			String page = PageResourceManager.getUrlPath("page.url.car.listview");
			response.sendRedirect(page);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the LogIn command", e);
		} catch (IOException e) {
			throw new CommandException("Error execution response function", e);
		}
	}
	
	/**
	 * Проверка параметров запроса
	 * 
	 * @param nickname ник пользователя
	 * @param password пароль пользователя 
	 * @return результат валидации
	 */
	private boolean isValidRequestParameter(String nickname, String password) {
		if (!isValidString(nickname, USER_NICKNAME_MIN_LENGTH, USER_NICKNAME_MAX_LENGTH) 
				|| !isValidString(password, USER_PASSWORD_MIN_LENGTH, USER_PASSWORD_MAX_LENGTH)) {
			return false;
		}
		return true;
	}

}
