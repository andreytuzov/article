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

public class LogIn implements ICommand {
	
	private static final Logger logger = Logger.getLogger(LogIn.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		UserService userService = ServiceFactory.getInstance().getUserService();
		try {
			String nickname = request.getParameter("nickname");
			String password = request.getParameter("password");
			
			User user = userService.findOneByNicknameAndPassword(nickname, password);
			
			if (user != null && user.getRole() != null) {
				request.getSession().setAttribute("user", nickname);
				request.getSession().setAttribute("role", user.getRole());
				if (user.getRole() == Role.ADMIN) {					
					request.getSession().setAttribute("admin", true);
				}
			}
		} catch (ServiceException e) {
			logger.error("Error execution the LogIn command", e);
		} catch (NumberFormatException e) {
			logger.error("Incorrect data format", e);
		}
		return PageResourceManager.getUrlPath("page.url.car.listview");
	}

}
