package by.epam.task.controller.command.impl.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.RequestParameter;
import by.epam.task.controller.command.SessionParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.service.DealService;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

import java.io.IOException;

/**
 * Команда для обработки запроса отображения страницы пользователя
 */
public class ViewModifyUserRoom implements ICommand {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		UserService userService = ServiceFactory.getInstance().getUserService();
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Getting info
		String nickname = request.getParameter(RequestParameter.USER_NICKNAME);
		String accessNickname = (String) request.getSession().getAttribute(SessionParameter.USER_NICKNAME);
		Boolean isAdmin = (Boolean) request.getSession().getAttribute(SessionParameter.ROLE_IS_ADMIN);
		System.out.println(nickname + ", " + accessNickname + ", " + isAdmin);
		if (isAdmin == null) {
			isAdmin = false;
		}
		// Data validation
		if (!isValidRequestParameter(nickname, accessNickname, isAdmin)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			request.setAttribute(RequestParameter.USER_OBJECT, userService.findOneByNickname(nickname));
			request.setAttribute(RequestParameter.DEAL_LIST, dealService.findAllByNickname(nickname));
			String page = PageResourceManager.getPagePath("page.name.user.room");
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the viewUserRoom command", e);
		} catch (ServletException | IOException e) {
			throw new CommandException("Error execution request function", e);
		} 
	}

	/**
	 * Проверка параметров запроса 
	 * 
	 * @param nickname ник пользователя
	 * @param accessNickname ник пользователя у которого есть доступ к методу
	 * @param isAdmin true - если роль администратора
	 * @return результат валидации
	 */
	private boolean isValidRequestParameter(String nickname, String accessNickname, boolean isAdmin) {
		if (!isValidString(nickname) || !(nickname.equals(accessNickname) || isAdmin)) {
			return false;
		}
		return true;
	}
	
}
