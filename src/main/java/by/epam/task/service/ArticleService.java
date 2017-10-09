package by.epam.task.service;

import java.util.List;

import by.epam.task.domain.Article;
import by.epam.task.service.exception.ServiceException;

public interface ArticleService {
	Article findOne(int id) throws ServiceException;

	List<Article> findAll() throws ServiceException;

	int delete(int id) throws ServiceException;

	int delete(List<Integer> listID) throws ServiceException;
		
	int saveOrUpdate(Article article) throws ServiceException;
}
