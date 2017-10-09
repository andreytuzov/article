package by.epam.task.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.CommandProvider;
import by.epam.task.controller.command.ICommand;
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
		
		String action = request.getParameter("action");
		CommandProvider commandProvider = CommandProvider.getInstance();
		ICommand command = commandProvider.getCommand(action);
		
		logger.debug("command = " + command);
		
		String page = command.execute(request);
	 
		logger.debug("page = " + page);
		
		request.getRequestDispatcher(page).forward(request, response);
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
