package by.epam.task.dao.factory;

import by.epam.task.dao.ArticleDAO;
import by.epam.task.dao.InitializingDAO;
import by.epam.task.dao.impl.ArticleDAOImpl;
import by.epam.task.dao.impl.InitializingDAOImpl;

public class DAOFactory {

	private static DAOFactory instance = new DAOFactory();

	private final ArticleDAO articleDAO = new ArticleDAOImpl();
	private final InitializingDAO initializingDAO = new InitializingDAOImpl();

	public static DAOFactory getInstance() {
		return instance;
	}

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	public InitializingDAO getInitializingDAO() {
		return initializingDAO;
	}

}
