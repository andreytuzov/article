package by.epam.task.dao.factory;

import by.epam.task.dao.ArticleDAO;
import by.epam.task.dao.impl.ArticleDAOImpl;

public class DAOFactory {

	private static DAOFactory instance = null;

	private final ArticleDAO articleDAO = new ArticleDAOImpl();
	
	public static DAOFactory getInstance() {
		if (instance == null) {
			synchronized (DAOFactory.class) {
				if (instance == null) {
					instance = new DAOFactory();
				}
			}
		}
		return instance;
	}

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}
	
}
