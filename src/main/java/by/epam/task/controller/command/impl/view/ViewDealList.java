package by.epam.task.controller.command.impl.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.controller.validator.Validator;
import by.epam.task.domain.Deal;
import by.epam.task.domain.DealState;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

public class ViewDealList implements ICommand {

	private static final Logger logger = Logger.getLogger(ViewDealList.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Getting user entered info
		String dealState = request.getParameter("dealState");
		// Data validation
		if (!isValidDealState(dealState)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			List<Deal> listDeal = dealService.findAllByDealState(DealState.valueOf(dealState));
			request.setAttribute("listDeal", listDeal);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the viewDealList command", e);
		}
		return PageResourceManager.getPagePath("page.name.deal.listview");
	}

}
