package by.epam.task.service;

import by.epam.task.service.exception.ServiceException;

public interface InitializingService {
	void init() throws ServiceException;

	void destroy() throws ServiceException;
}
