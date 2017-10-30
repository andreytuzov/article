package by.epam.task.dao;

import java.util.List;

import by.epam.task.dao.exception.DAOException;
import by.epam.task.domain.User;

/**
 * Интерфейс, содержащий функции для работы с таблицей users 
 */
public interface UserDAO {

	/**
	 * Метод для получения списка объектов пользователей по указанному ник и паролю
	 * 
	 * @param nickname ник пользователя
	 * @param password пароль пользователя
	 * @return объект пользователя
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	User findOneByNicknameAndPassword(String nickname, String password) throws DAOException;
	
	/**
	 * Метод для получения объекта пользователя по указанному нику
	 * 
	 * @param nickname ник пользователя
	 * @return объект пользователя
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	User findOneByNickname(String nickname) throws DAOException;

	/**
	 * Метод для получения списка всех объектов-пользователей 
	 * 
	 * @return список всех объектов пользователей
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	List<User> findAll() throws DAOException;

	/**
	 * Метод для добавления записи пользователя в таблицу
	 * 
	 * @param user объект пользователя
	 * @param password пароль пользователя
	 * @return идентификатор добавленной записи
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	int insert(User user, String password) throws DAOException;
	
	/**
	 * Метод для обновления записи пользователя в таблице
	 * 
	 * @param user объект пользователя
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	void update(User user) throws DAOException;

	/**
	 * Метод для получения объекта пользователя по указанному идентификатору
	 * 
	 * @param id идентификатор пользователя 
	 * @return объект пользователя
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	User findOne(int id) throws DAOException;
}
