package by.epam.task.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.CommandProvider;
import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.RequestParameter;
import by.epam.task.controller.command.SessionParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.controller.validator.Validator;
import by.epam.task.dao.connection.manager.DBType;
import by.epam.task.domain.Role;
import by.epam.task.service.InitializingService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

/** 
 * Контроллер для обработки всех запросов 
 */
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/** Объект логгера */
	private static final Logger logger = Logger.getLogger(DispatcherServlet.class);
	
	/** Сервис инициализации */
	private static final InitializingService initializingService = ServiceFactory.getInstance().getInitializingService();
	
	/** 
	 * Метод первоначальной инициализации объектов 
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			initializingService.init(DBType.DB_MAIN);
		} catch (ServiceException e) {
			logger.error("Error completing initialization", e);
			throw new ServletException("Error initialization", e);
		}
	}
	
	/** 
	 * Метод для обработки всех запросов 
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Getting data
		String action = request.getParameter(RequestParameter.ACTION);
		Role role = (Role) request.getSession().getAttribute(SessionParameter.ROLE_NAME);
		try {
			ICommand command = CommandProvider.getInstance().getCommand(action, role);
			command.execute(request, response);
		} catch (CommandException e) {
			logger.error("Error execution a command", e);
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	}
	
	/** 
	 * Метод освобождения используемых ресурсов 
	 */
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
