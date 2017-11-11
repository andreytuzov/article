package by.epam.task.controller.command.impl.view;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.RequestParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Deal;
import by.epam.task.domain.DealState;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

/**
 * Команда для обработки запроса отображения списка автомобилей  
 */
public class ViewDealList implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Getting user entered info
		String dealState = request.getParameter(RequestParameter.DEAL_STATE_NAME);
		// Data validation
		if (!isValidDealState(dealState)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			List<Deal> listDeal = dealService.findAllByDealState(DealState.valueOf(dealState));
			request.setAttribute(RequestParameter.DEAL_LIST, listDeal);
			String page = PageResourceManager.getPagePath("page.name.deal.listview");
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the viewDealList command", e);
		} catch (ServletException | IOException e) {
			throw new CommandException("Error execution request function", e);
		} 
		
	}
}
