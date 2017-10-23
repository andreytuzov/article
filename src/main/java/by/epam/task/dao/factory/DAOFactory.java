package by.epam.task.dao.factory;

import by.epam.task.dao.CarDAO;
import by.epam.task.dao.DamageDAO;
import by.epam.task.dao.DealDAO;
import by.epam.task.dao.InitializingDAO;
import by.epam.task.dao.UserDAO;
import by.epam.task.dao.impl.CarDAOImpl;
import by.epam.task.dao.impl.DamageDAOImpl;
import by.epam.task.dao.impl.DealDAOImpl;
import by.epam.task.dao.impl.InitializingDAOImpl;
import by.epam.task.dao.impl.UserDAOImpl;

public class DAOFactory {

	private static DAOFactory instance = new DAOFactory();

	private final CarDAO carDAO = new CarDAOImpl();
	private final UserDAO userDAO = new UserDAOImpl();
	private final InitializingDAO initializingDAO = new InitializingDAOImpl();
	private final DealDAO dealDAO = new DealDAOImpl();
	private final DamageDAO damageDAO = new DamageDAOImpl();

	public static DAOFactory getInstance() {
		return instance;
	}

	public CarDAO getCarDAO() {
		return carDAO;
	}

	public InitializingDAO getInitializingDAO() {
		return initializingDAO;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public DealDAO getDealDAO() {
		return dealDAO;
	}

	public DamageDAO getDamageDAO() {
		return damageDAO;
	}

}
