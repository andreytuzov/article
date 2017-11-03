package by.epam.task.service.impl;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.task.dao.connection.manager.DBType;
import by.epam.task.domain.Car;
import by.epam.task.service.CarService;
import by.epam.task.service.InitializingService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;
import org.junit.Assert;
import org.junit.Before;

public class TestCarService  {
	
	private static final Logger logger = Logger.getLogger(TestCarService.class);
	
	private static CarService carService;
	private static InitializingService initializingService;
	
	private Car car;
	
	@BeforeClass
	public static void init() {
		BasicConfigurator.configure();
		initializingService = ServiceFactory.getInstance().getInitializingService();
		carService = ServiceFactory.getInstance().getCarService();	
		try {
			initializingService.init(DBType.DB_TEST);
		} catch (ServiceException e) {
			logger.error("Error initialization pool", e);
		}
	}
	
	@AfterClass
	public static void destroy() {
		try {
			initializingService.destroy();
		} catch (ServiceException e) {
			logger.error("Error destroing pool", e);
		}
	}
	
	@Before
	public void createCar() {
		car = new Car(0, "Opel Astra", 2001, 1.7f, 76, 1.3f, "Описание автомобиля");
		try {
			int id = carService.modify(car);
			car.setId(id);
		} catch (ServiceException e) {
			logger.error("Error creating car", e);
		}
	}
	
	@Test
	public void modifyTest() {	
		try {
			Car expectedCar = new Car(car.getId(), "VW Polo", 2015, 1.6f, 90, 2, "Description car");
			
			carService.modify(expectedCar);
			Car realCar = carService.findOne(expectedCar.getId());
			
			Assert.assertEquals(expectedCar, realCar);
		} catch (ServiceException e) {
			logger.error("Error execution carService method", e);
		}
	}
	
	@Test
	public void readTest() {	
		try {
			Car realCar = carService.findOne(car.getId());
			
			Assert.assertEquals(car, realCar);
		} catch (ServiceException e) {
			logger.error("Error execution carService method", e);
		}
	}
	
	@Test(expected = ServiceException.class)
	public void deleteTest() throws ServiceException {	
		carService.delete(car.getId());
		carService.findOne(car.getId());
	}

}
