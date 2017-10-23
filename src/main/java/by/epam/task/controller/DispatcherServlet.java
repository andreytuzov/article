package by.epam.task.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.CommandProvider;
import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.AccessCommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Role;
import by.epam.task.service.InitializingService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class DispatcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(DispatcherServlet.class);
	
	private static final InitializingService initializingService = ServiceFactory.getInstance().getInitializingService();
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			initializingService.init();
		} catch (ServiceException e) {
			logger.error("Error completing initialization", e);
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			Role role = (Role) request.getSession().getAttribute("role");
			if (role == null) {
				role = Role.ANONYMOUS;
			}
			
			ICommand command = CommandProvider.getInstance().getCommand(action, role);
			String page = command.execute(request, response);
			if (page != null) {
				if (page.indexOf("/WEB-INF/") == -1) {
					response.sendRedirect(page);
				} else {
					request.getRequestDispatcher(page).forward(request, response);
				}
			}
		} catch (AccessCommandException e) {
			logger.error("Access error execution command", e);
			response.sendRedirect(PageResourceManager.getUrlPath("page.url.user.login"));
		}
	}
	
	@Override
	public void destroy() {
		super.destroy();
		try {
			initializingService.destroy();
		} catch (ServiceException e) {
			logger.error("Error completing destroing", e);
		}

	}
	
}
