package by.epam.task.controller.command.impl.view;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Deal;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class ViewDealList implements ICommand {

	private static final Logger logger = Logger.getLogger(ViewDealList.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		DealService dealService = ServiceFactory.getInstance().getDealService();
		try {
			List<Deal> listDeal = dealService.findAll();
			request.setAttribute("listDeal", listDeal);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the viewDealList command", e);
		}
		return PageResourceManager.getPagePath("page.name.deal.listview");
	}

}
