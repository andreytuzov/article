package by.epam.task.dao;

import java.util.List;

import by.epam.task.dao.exception.DaoException;
import by.epam.task.domain.Article;

public interface ArticleDAO {
	Article findOne(int id) throws DaoException;

	List<Article> findAll() throws DaoException;

	int delete(int id) throws DaoException;

	int delete(List<Integer> listID) throws DaoException;
		
	int saveOrUpdate(Article article) throws DaoException;
}
