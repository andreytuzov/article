package by.epam.task.controller.command.impl;

import static by.epam.task.controller.validator.Validator.isValidEmail;
import static by.epam.task.controller.validator.Validator.isValidInt;
import static by.epam.task.controller.validator.Validator.isValidPhone;
import static by.epam.task.controller.validator.Validator.isValidString;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.User;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class ModifyUser implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		UserService userService = ServiceFactory.getInstance().getUserService();
		// Getting user entered info
		String nickname = request.getParameter("nickname");
		String name = request.getParameter("name");
		String lastname = request.getParameter("lastname");
		String drivenExperience = request.getParameter("drivenExperience");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String accessNickname = (String) request.getSession().getAttribute("user");
		// Data validation
		if (!isValidString(nickname, 5, 25) || !isValidString(lastname, 2, 30) || !isValidInt(drivenExperience) 
				|| !isValidPhone(phone) || !isValidEmail(email) || !nickname.equals(accessNickname)) {
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
		return null;
	}

}
