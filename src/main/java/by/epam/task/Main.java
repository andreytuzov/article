package by.epam.task;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.epam.task.dao.CarDAO;
import by.epam.task.dao.InitializingDAO;
import by.epam.task.dao.exception.DaoException;
import by.epam.task.dao.factory.DAOFactory;
import by.epam.task.domain.Article;

public class Main {
	
	private static final Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws DaoException {	
		DAOFactory daoFactory = new DAOFactory();
		InitializingDAO initializingDAO = daoFactory.getInitializingDAO();
		initializingDAO.init();
		CarDAO articleDAO = daoFactory.getArticleDAO();
		print(articleDAO.findAll());		
	}
	
	private static void print(List<Article> listArticle) {
		for (Article article : listArticle) {
			logger.debug(article);
		}
	}
}
