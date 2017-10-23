package by.epam.task.dao;

import by.epam.task.dao.exception.DAOException;

public interface InitializingDAO {
	void init() throws DAOException;

	void destroy() throws DAOException;
}
