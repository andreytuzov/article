package by.epam.task.controller.command.impl.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class ViewUserList implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		UserService userService = ServiceFactory.getInstance().getUserService();
		try {
			request.setAttribute("listUser", userService.findAll());
		} catch (ServiceException e) {
			throw new CommandException("Error executing the viewUserList command", e);
		}
		return PageResourceManager.getPagePath("page.name.user.listview");
	}

}
