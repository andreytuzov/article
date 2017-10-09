package by.epam.task.service.impl;

import java.util.List;

import by.epam.task.dao.ArticleDAO;
import by.epam.task.dao.exception.DaoException;
import by.epam.task.dao.factory.DAOFactory;
import by.epam.task.domain.Article;
import by.epam.task.service.ArticleService;
import by.epam.task.service.exception.ServiceException;

public class ArticleServiceImpl implements ArticleService {

	private final ArticleDAO articleDAO = DAOFactory.getInstance().getArticleDAO();
	
	@Override
	public Article findOne(int id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findAll() throws ServiceException {
		List<Article> listArticle = null;
		try {
			listArticle = articleDAO.findAll();
		} catch (DaoException e) {
			throw new ServiceException("Error completing findAll", e);
		}
		if (listArticle == null) {
			throw new ServiceException("Articles was not found");
		}
		return listArticle;
	}

	@Override
	public int delete(int id) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(List<Integer> listID) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveOrUpdate(Article article) throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
