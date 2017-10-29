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

public class SignUp implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		UserService userService = ServiceFactory.getInstance().getUserService();
		// Getting user entered info
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String drivenExperience = request.getParameter("drivenExperience");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		// Data validation
		if (!isValidString(nickname, 5, 25) || !isValidString(password, 5, 25) || !isValidString(lastname, 2, 30) 
				|| !isValidInt(drivenExperience) || !isValidPhone(phone) || !isValidEmail(email)) {
			throw new CommandException("Incorrect request data");
		}
		User user = new User(0, nickname, name, lastname, 
				phone, email, Integer.valueOf(drivenExperience), Role.CUSTOMER);
		try {
			userService.add(user, password);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the signUp command", e);
		}
		return null;
	}

}
