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

/**
 * Класс-фабрика dao-объектов  
 */
public class DAOFactory {

	/** Единственный экземпляр данной фабрики */
	private static DAOFactory instance = new DAOFactory();

	/** Класс для работы с таблицей cars */
	private final CarDAO carDAO = new CarDAOImpl();
	/** Класс для работы с таблицей users */
	private final UserDAO userDAO = new UserDAOImpl();
	/** Класс для получения соединений к базе данных */
	private final InitializingDAO initializingDAO = new InitializingDAOImpl();
	/** Класс для работы с таблицей deals */
	private final DealDAO dealDAO = new DealDAOImpl();
	/** Класс для работы с таблицей damages */
	private final DamageDAO damageDAO = new DamageDAOImpl();

	/**
	 * Получение экземпляра данной фабрики
	 * 
	 * @return экземпляр данной фабрики
	 */
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
