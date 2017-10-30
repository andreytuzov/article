package by.epam.task.service;

import java.util.List;

import by.epam.task.domain.User;
import by.epam.task.service.exception.ServiceException;

/**
 * Интерфейс, содержащий функции для работы с объектом бизнес данных User
 */
public interface UserService {	
	
	/**
	 * Метод для получени объекта пользователя по его нику
	 * 
	 * @param nickname ник пользователя 
	 * @return объект пользователя
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	User findOneByNickname(String nickname) throws ServiceException;
	
	/**
	 * Метод для получения объекта пользователя по его нику и паролю
	 * 
	 * @param nickname ник пользователя
	 * @param password пароль пользователя
	 * @return объект пользователя
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	User findOneByNicknameAndPassword(String nickname, String password) throws ServiceException;

	/**
	 * Метод для получения списка всех пользователей
	 * 
	 * @return список пользователей
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	List<User> findAll() throws ServiceException;
	
	/**
	 * Метод для добавления пользователя 
	 * 
	 * @param user объект пользователя
	 * @param password пароль
	 * @return идентификатор пользователя
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	int add(User user, String password) throws ServiceException;
	
	/**
	 * Метод для обнавления пользователя 
	 * 
	 * @param user объект пользователя
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	void update(User user) throws ServiceException;
	
	/**
	 * Метод для получения объекта пользователя по его идентификатору 
	 * 
	 * @param id идентификатор пользователя
	 * @return объкт пользователя
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	User findOne(int id) throws ServiceException;
}
