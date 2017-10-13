package by.epam.task.dao.factory;

import by.epam.task.dao.CarDAO;
import by.epam.task.dao.InitializingDAO;
import by.epam.task.dao.impl.CarDAOImpl;
import by.epam.task.dao.impl.InitializingDAOImpl;

public class DAOFactory {

	private static DAOFactory instance = new DAOFactory();

	private final CarDAO articleDAO = new CarDAOImpl();
	private final InitializingDAO initializingDAO = new InitializingDAOImpl();

	public static DAOFactory getInstance() {
		return instance;
	}

	public CarDAO getArticleDAO() {
		return articleDAO;
	}

	public InitializingDAO getInitializingDAO() {
		return initializingDAO;
	}

}
