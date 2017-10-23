package by.epam.task.service.impl;

import by.epam.task.dao.InitializingDAO;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.factory.DAOFactory;
import by.epam.task.service.InitializingService;
import by.epam.task.service.exception.ServiceException;

public class InitializingServiceImpl implements InitializingService {

	private final InitializingDAO initializingDAO = DAOFactory.getInstance().getInitializingDAO();
	
	@Override
	public void init() throws ServiceException {
		try {
			initializingDAO.init();
		} catch (DAOException e) {
			throw new ServiceException("Error initialization", e);
		}
	}

	@Override
	public void destroy() throws ServiceException {
		try {
			initializingDAO.destroy();
		} catch (DAOException e) {
			throw new ServiceException("Error destroing", e);
		}
	}

}
