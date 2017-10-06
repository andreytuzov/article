package by.epam.task;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import by.epam.task.dao.ArticleDAO;
import by.epam.task.dao.exception.DaoException;
import by.epam.task.dao.factory.DAOFactory;
import by.epam.task.domain.Article;

public class Main {
	
	private static final Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) throws DaoException {	
		
		
		DAOFactory daoFactory = new DAOFactory();
		ArticleDAO articleDAO = daoFactory.getArticleDAO();
		
		print(articleDAO.findAll());		
	}
	
	private static void print(Iterable<Article> articles) {
		Iterator<Article> iterator = articles.iterator();
		while (iterator.hasNext()) {
			logger.debug(iterator.next());
		}
	}
}
