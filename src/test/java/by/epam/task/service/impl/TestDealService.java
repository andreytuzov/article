package by.epam.task.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import by.epam.task.dao.DealDAO;
import by.epam.task.dao.connection.manager.DBType;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.factory.DAOFactory;
import by.epam.task.domain.Car;
import by.epam.task.domain.Deal;
import by.epam.task.domain.DealState;
import by.epam.task.domain.Role;
import by.epam.task.domain.User;
import by.epam.task.service.CarService;
import by.epam.task.service.DealService;
import by.epam.task.service.InitializingService;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class TestDealService {

	private static final Logger logger = Logger.getLogger(TestDealService.class);
	
	private static int CAR_ID = 1;
	private static final String USER_NICKNAME = "m10";
	private static final String USER_PASSWORD = "12345678";
	
	private static InitializingService initializingService;
	private static DealService dealService;
	private static UserService userService;
	private static CarService carService;
	
	private static DealDAO dealDAO;
	
	private static User user;
	private static Car car;
	private List<Deal> listDeal;
	
	private Car createCar() {
		Car car = null;
		try {
			car = new Car(CAR_ID, "Opel Astra", 2001, 1.7f, 76, 1.3f, "Описание автомобиля");
			CAR_ID = carService.modify(car);
			car.setId(CAR_ID);
		} catch (ServiceException e) {
			logger.error("Error creating car", e);
		}
		return car;
	}
	
	public User createUser() {
		User user = null;
		try {
			if (userService.checkNickname(USER_NICKNAME)) {
				user = new User(0, USER_NICKNAME, "Andrey", "Ivanov", "+375 (29) 123-23-21", "m10@mail.ru", 5, Role.CUSTOMER);
				int id = userService.add(user, USER_PASSWORD);
				user.setId(id);
			} else {
				user = userService.findOneByNickname(USER_NICKNAME);
			}
		} catch (ServiceException e) {
			logger.error("Error adding user", e);
		}
		return user;
	}
	
	@BeforeClass
	public static void init() {
		initializingService = ServiceFactory.getInstance().getInitializingService();
		dealService = ServiceFactory.getInstance().getDealService();
		userService = ServiceFactory.getInstance().getUserService();
		carService = ServiceFactory.getInstance().getCarService();
		dealDAO = DAOFactory.getInstance().getDealDAO();
		try {
			initializingService.init(DBType.DB_TEST);
		} catch (ServiceException e) {
			logger.error("Error initialization of connection to database", e);
		}
	}
	
	@AfterClass
	public static void destroy() {
		try {
			initializingService.destroy();
		} catch (ServiceException e) {
			logger.error("Error destroing connection with database", e);
		}
	}
	
	@Before
	public void createDeals() {
		deleteAll();
		
		int countMillisInHour = 3600000;
		long now = new Date().getTime();
		Date dateFrom = new Date(now + countMillisInHour);
		Date dateTo = new Date(now + countMillisInHour * 5);
		
		Deal deal = new Deal(0, 1, dateFrom, dateTo, "comment", "cancelReason", user, car, null, DealState.CREATED, "HD 123456");
		
		deal = new Deal(0, 1, dateFrom, dateTo, "comment", null, user, car, null, DealState.CREATED, "HD 123456");
		
		try {
			dealDAO.insert(deal);
			
			
			
		} catch (DAOException e) {
			logger.error("Error working with database connection with database", e);
		}
		
	}
	
	/**
	 * Метод для удаления всех сделок
	 */
	private void deleteAll() {
		try {
			List<Deal> listDeal = dealService.findAll();
			for (Deal deal : listDeal) {
				dealService.delete(deal.getId());
			}
 		} catch (ServiceException e) {
			logger.error("Error deleting all deals", e);
		
		}
	}
	
	
	
}
