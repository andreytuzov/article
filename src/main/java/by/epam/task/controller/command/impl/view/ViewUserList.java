package by.epam.task.controller.command.impl.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.RequestParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

/**
 * Команда для обработки запроса отображения списка пользователей
 */
public class ViewUserList implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		UserService userService = ServiceFactory.getInstance().getUserService();
		try {
			request.setAttribute(RequestParameter.USER_LIST, userService.findAll());
			String page = PageResourceManager.getPagePath("page.name.user.listview");
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServiceException e) {
			throw new CommandException("Error executing the viewUserList command", e);
		} catch (ServletException | IOException e) {
			throw new CommandException("Error execution request function", e);
		}
	}

}
