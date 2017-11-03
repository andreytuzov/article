package by.epam.task.dao;

import by.epam.task.dao.connection.manager.DBType;
import by.epam.task.dao.exception.DAOException;

/**
 * Интерфейс, содержащий функции для работы с соединением с базой данных
 */
public interface InitializingDAO {
	/**
	 * Метод для инициализации пула соединений
	 * 
	 * @param dbType тип базы данных
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	void init(DBType dbType) throws DAOException;

	/**
	 * Метод для освобождения ресурсов 
	 * 
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	void destroy() throws DAOException;
}
