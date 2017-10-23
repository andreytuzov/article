package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Role;
import by.epam.task.domain.User;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class SignUp implements ICommand {

	private static final Logger logger = Logger.getLogger(SignUp.class);
	
	private final UserService userService = ServiceFactory.getInstance().getUserService();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String username = request.getParameter("nickname");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String lastname = request.getParameter("lastname");
			int drivenExperience = Integer.valueOf(request.getParameter("drivenExperience"));
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			
			User user = new User();
			user.setNickname(username);
			user.setName(name);
			user.setLastname(lastname);
			user.setDrivenExperience(drivenExperience);
			user.setPhone(phone);
			user.setEmail(email);
			user.setRole(Role.CUSTOMER);
			
			userService.insert(user, password);
		} catch (ServiceException e) {
			logger.error("Error execution the signUp command", e);
		}
		return PageResourceManager.getUrlPath("page.url.user.login");
	}

}
