package by.epam.task.dao;

import by.epam.task.dao.exception.DaoException;

public interface InitializingDAO {
	void init() throws DaoException;

	void destroy() throws DaoException;
}
