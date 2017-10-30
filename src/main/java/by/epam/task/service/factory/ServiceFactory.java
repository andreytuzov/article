package by.epam.task.service.factory;

import by.epam.task.service.CarService;
import by.epam.task.service.DealService;
import by.epam.task.service.InitializingService;
import by.epam.task.service.UserService;
import by.epam.task.service.impl.CarServiceImpl;
import by.epam.task.service.impl.DealServiceImpl;
import by.epam.task.service.impl.InitializingServiceImpl;
import by.epam.task.service.impl.UserServiceImpl;

/**
 * Класс-фабрика service-объектов  
 */
public class ServiceFactory {
	
	/** Единственный экземпляр данной фабрики */
	private static final ServiceFactory instance = new ServiceFactory();

	/** Класс для работы с объектом бизнес данных Car */
	private final CarService carService = new CarServiceImpl();
	/** Класс для работы с объектом бизнес данных User */
	private final UserService userService = new UserServiceImpl();
	/** Класс для инициализации приложения */
	private final InitializingService initializingService = new InitializingServiceImpl();
	/** Класс для работы с объектом бизнес данных Deal */
	private final DealService dealService = new DealServiceImpl();

	/**
	 * Получение экземпляра данной фабрики
	 * 
	 * @return экземпляр данной фабрики
	 */
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
