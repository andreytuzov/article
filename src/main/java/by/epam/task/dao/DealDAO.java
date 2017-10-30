package by.epam.task.dao;

import java.util.Date;
import java.util.List;

import by.epam.task.dao.exception.DAOException;
import by.epam.task.domain.Deal;
import by.epam.task.domain.DealState;

/**
 * Интерфейс, содержащий функции для работы с таблицей deals
 */
public interface DealDAO {
	
	/**
	 * Метод для получения объекта заказа по указаному идентификатору
	 * 
	 * @param id идентификатор
	 * @return объект заказа
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	Deal findOne(int id) throws DAOException;
	
	/**
	 * Метод для получения списка объектов заказов для указанного пользователя
	 * 
	 * @param nickname имя пользователя
	 * @return список объектов заказов
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	List<Deal> findAllByNickname(String nickname) throws DAOException;

	/**
	 * Метод для получения списка объктов заказов указанного состояния
	 * 
	 * @param dealState состояния заказа
	 * @return список объектов заказов
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	List<Deal> findAllByDealState(DealState dealState) throws DAOException;
	
	/**
	 * Метод для получения списка будущих заказов для указанного автомобиля
	 * 
	 * @param id идентификатор автомобиля
	 * @return список объектов заказов 
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	List<Deal> findAllByCarAfterNow(int id) throws DAOException;
	
	/**
	 * Метод для получения списка объектов заказов даты которых пересекаются с указанными для данного автомобиля
	 * 
	 * @param id идентификатор автомобиля
	 * @param dateFrom дата начала проката
	 * @param dateTo дата оканчания проката
	 * @return список объектов заказов
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	List<Deal> findAllByCarBetweenDate(int id, Date dateFrom, Date dateTo) throws DAOException;
	
	/**
	 * Метод для получения списка всех объектов заказов
	 * 
	 * @return список объектов заказов
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	List<Deal> findAll() throws DAOException;

	/**
	 * Метод для удаления записи заказа
	 * 
	 * @param id идентификатор заказа
	 * @return количество удаленных записей
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	int delete(int id) throws DAOException;
		
	/**
	 * Метод для добавления записи заказа
	 * 
	 * @param deal объект заказа
	 * @return идентификатор добавленной записи
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	int insert(Deal deal) throws DAOException;
	
	/**
	 * Метод для обновления записи заказа
	 * 
	 * @param deal объект заказа
	 * @return идентификатор обновленной записи
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	int update(Deal deal) throws DAOException;
}
