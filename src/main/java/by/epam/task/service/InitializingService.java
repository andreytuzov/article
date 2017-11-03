package by.epam.task.service;

import by.epam.task.dao.connection.manager.DBType;
import by.epam.task.service.exception.ServiceException;

/**
 * Интерфейс, содержащий функции для работы с соединением с базой данных
 */
public interface InitializingService {
	/**
	 * Метод для инициализации объектов приложения
	 * 
	 * @param dbType тип базы данных
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	void init(DBType dbType) throws ServiceException;

	/**
	 * Метод для освобождения объектов приложения
	 * 
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	void destroy() throws ServiceException;
}
