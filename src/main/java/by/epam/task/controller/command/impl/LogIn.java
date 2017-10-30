package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Role;
import by.epam.task.domain.User;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

/**
 * Команда для обработки аутентификации пользователя 
 */
public class LogIn implements ICommand {
		
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		UserService userService = ServiceFactory.getInstance().getUserService();
		// Getting user entered info
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		// Data validation
		if (!isValidString(nickname, 5, 25) || !isValidString(password, 5, 25)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			User user = userService.findOneByNicknameAndPassword(nickname, password);
			// Setting session attributes
			request.getSession().setAttribute("user", nickname);
			request.getSession().setAttribute("role", user.getRole());
			if (user.getRole() == Role.ADMIN) {					
				request.getSession().setAttribute("admin", true);
			}
		} catch (ServiceException e) {
			throw new CommandException("Error execution the LogIn command", e);
		} 
		return PageResourceManager.getUrlPath("page.url.car.listview");
	}

}
