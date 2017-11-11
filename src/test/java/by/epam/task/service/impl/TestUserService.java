package by.epam.task.service.impl;

import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.task.dao.connection.manager.DBType;
import by.epam.task.domain.Role;
import by.epam.task.domain.User;
import by.epam.task.service.InitializingService;
import by.epam.task.service.UserService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class TestUserService {
	
	private static final Logger logger = Logger.getLogger(TestUserService.class);
	
	private static final String USER_NICKNAME = "m10";
	private static final String USER_PASSWORD = "12345678";
	
	private static InitializingService initializingService;
	private static UserService userService;
	
	private User user;
	
	@BeforeClass
	public static void init() {
		initializingService = ServiceFactory.getInstance().getInitializingService();
		userService = ServiceFactory.getInstance().getUserService();
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
	public void createUser() {
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
	}
	
	@Test
	public void readUserTest() {
		try {
			User realUser = userService.findOne(user.getId());
			Assert.assertEquals(user, realUser);
			
			realUser = userService.findOneByNickname(user.getNickname());
			Assert.assertEquals(user, realUser);
			
			realUser = userService.findOneByNicknameAndPassword(user.getNickname(), USER_PASSWORD);
			Assert.assertEquals(user, realUser);
		} catch (ServiceException e) {
			logger.error("Error execution findOne method of user's service", e);
		}
	}
	
	@Test
	public void modifyUserTest() {
		Random random = new Random();
		int index = random.nextInt(20) + 1;
		User expectedUser = new User(user.getId(), "m10", "Ivan" + index, "Alex" + index, "+375 (29) 521-43-21", "masd@mail.ru", index, Role.CUSTOMER); 
		try {
			userService.update(expectedUser);
			User realUser = userService.findOne(expectedUser.getId());
			Assert.assertEquals(expectedUser, realUser);
		} catch (ServiceException e) {
			logger.error("Error execution update method of user's service", e);
		}
	}
}
