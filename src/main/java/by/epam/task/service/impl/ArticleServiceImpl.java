package by.epam.task.service.impl;

import java.util.List;

import by.epam.task.dao.CarDAO;
import by.epam.task.dao.exception.DaoException;
import by.epam.task.dao.factory.DAOFactory;
import by.epam.task.domain.Article;
import by.epam.task.service.ArticleService;
import by.epam.task.service.exception.ServiceException;

public class ArticleServiceImpl implements ArticleService {

	private final CarDAO articleDAO = DAOFactory.getInstance().getArticleDAO();
	
	@Override
	public Article findOne(int id) throws ServiceException {
		Article article = null;
		try {
			article = articleDAO.findOne(id);
		} catch (DaoException e) {
			throw new ServiceException("Error completing findOne", e);
		}
		if (article == null) {
			throw new ServiceException("Article was not found");
		}
		return article;
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
			throw new ServiceException("Articles were not found");
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
