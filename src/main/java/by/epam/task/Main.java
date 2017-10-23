package by.epam.task;

import java.util.List;

import org.apache.log4j.Logger;

import by.epam.task.dao.CarDAO;
import by.epam.task.dao.InitializingDAO;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.factory.DAOFactory;
import by.epam.task.domain.Car;

public class Main {
	
	private static final Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws DAOException {	
		DAOFactory daoFactory = new DAOFactory();
		InitializingDAO initializingDAO = daoFactory.getInitializingDAO();
		initializingDAO.init();
		CarDAO carDAO = daoFactory.getCarDAO();
		print(carDAO.findAll());		
	}
	
	private static void print(List<Car> list) {
		for (Car object : list) {
			logger.debug(object);
		}
	}
}
