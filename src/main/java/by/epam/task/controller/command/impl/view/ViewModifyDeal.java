package by.epam.task.controller.command.impl.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.command.RequestParameter;
import by.epam.task.controller.command.SessionParameter;
import by.epam.task.controller.command.exception.CommandException;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Car;
import by.epam.task.domain.Deal;
import by.epam.task.service.CarService;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

import static by.epam.task.controller.validator.Validator.*;

import java.io.IOException;

/**
 * Команда для обработки запроса отображения страницы для редактирования заказа  
 */
public class ViewModifyDeal implements ICommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {
		CarService carService = ServiceFactory.getInstance().getCarService();
		DealService dealService = ServiceFactory.getInstance().getDealService();
		// Getting info
		String id = request.getParameter(RequestParameter.DEAL_ID);
		String carId = request.getParameter(RequestParameter.CAR_ID);
		// Data validation
		Boolean isAdmin = (Boolean) request.getSession().getAttribute(SessionParameter.ROLE_IS_ADMIN);
		if (isAdmin == null) {
			isAdmin = false;
		}
		if (!isValidRequestParameter(id, isAdmin, carId)) {
			throw new CommandException("Incorrect request data");
		}
		try {
			if (isValidInt(id)) {
				Deal deal = dealService.findOne(Integer.valueOf(id));
				request.setAttribute(RequestParameter.DEAL_OBJECT, deal);
				request.setAttribute(RequestParameter.CAR_OBJECT, deal.getCar());
			} else {
				Car car = carService.findOne(Integer.valueOf(carId));
				request.setAttribute(RequestParameter.CAR_OBJECT, car);
				request.setAttribute(RequestParameter.DEAL_LIST_CAR_SCHEDULE, dealService.findAllByCarAfterNow(car.getId()));
			}
			String page; 
			if (isAdmin) {
				page = PageResourceManager.getPagePath("page.name.deal.modify-admin");		
			} else {
				page = PageResourceManager.getPagePath("page.name.deal.modify-customer");		
			}
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServiceException e) {
			throw new CommandException("Error execution the viewModifyDeal command", e);
		} catch (ServletException | IOException e) {
			throw new CommandException("Error execution request function", e);
		} 
	}

	/**
	 * Проверка параметров запроса
	 * 
	 * @param id идентификатор заказа
	 * @param isAdmin true - если роль администратора
	 * @param carId идентификатор автомобиля
	 * @return результат валидации
	 */
	private boolean isValidRequestParameter(String id, boolean isAdmin, String carId) {
		if (!(isValidInt(id) || !isAdmin && isValidInt(carId))) {
			return false;
		}
		return true;
	}
	
}
