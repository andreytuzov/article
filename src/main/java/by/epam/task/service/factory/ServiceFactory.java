package by.epam.task.service.factory;

import by.epam.task.service.CarService;
import by.epam.task.service.DealService;
import by.epam.task.service.InitializingService;
import by.epam.task.service.UserService;
import by.epam.task.service.impl.CarServiceImpl;
import by.epam.task.service.impl.DealServiceImpl;
import by.epam.task.service.impl.InitializingServiceImpl;
import by.epam.task.service.impl.UserServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final CarService carService = new CarServiceImpl();
	private final UserService userService = new UserServiceImpl();
	private final InitializingService initializingService = new InitializingServiceImpl();
	private final DealService dealService = new DealServiceImpl();

	public static ServiceFactory getInstance() {
		return instance;
	}

	public CarService getCarService() {
		return carService;
	}

	public InitializingService getInitializingService() {
		return initializingService;
	}

	public UserService getUserService() {
		return userService;
	}

	public DealService getDealService() {
		return dealService;
	}
}
