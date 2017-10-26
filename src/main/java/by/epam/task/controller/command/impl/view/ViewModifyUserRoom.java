package by.epam.task.controller.command.impl.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.service.DealService;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

public class ViewModifyUserRoom implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		UserService userService = ServiceFactory.getInstance().getUserService();
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Getting info
		String nickname = request.getParameter("nickname");
		// Data validation
		if (!isValidString(nickname)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			request.setAttribute("userObject", userService.findOneByNickname(nickname));
			request.setAttribute("listDeal", dealService.findAllByNickname(nickname));
		} catch (ServiceException e) {
			throw new CommandException("Error execution the viewUserRoom command", e);
		}
		return PageResourceManager.getPagePath("page.name.user.room");
	}

}
