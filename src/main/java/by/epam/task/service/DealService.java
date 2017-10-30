package by.epam.task.service;

import java.util.Date;
import java.util.List;

import by.epam.task.domain.Deal;
import by.epam.task.domain.DealState;
import by.epam.task.service.exception.ServiceException;

/**
 * Интерфейс, содержащий функции для работы с объектом бизнес данных Deal 
 */
public interface DealService {

	/**
	 * Метод для получения объекта заказа по идентификатору
	 *  
	 * @param id идентификатор заказа
	 * @return объект заказа
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	Deal findOne(int id) throws ServiceException;

	/**
	 * Метод для получения списка объектов заказов для указанного ника пользователя
	 * 
	 * @param nickname ник пользователя
	 * @return список объектов заказов
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	List<Deal> findAllByNickname(String nickname) throws ServiceException;

	/**
	 * Метод для получения списка актуальных объектов заказов для указанного автомобиля
	 * 
	 * @param id идентификатор автомобиля 
	 * @return список объектов заказов
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	List<Deal> findAllByCarAfterNow(int id) throws ServiceException;

	/**
	 * Метод для получения списка объектов заказов для указанного состояния
	 * 
	 * @param dealState состояние заказа
	 * @return список заказов
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	List<Deal> findAllByDealState(DealState dealState) throws ServiceException;

	/**
	 * Метод для получения всех объектов заказов 
	 * 
	 * @return список объектов заказов
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	List<Deal> findAll() throws ServiceException;

	/**
	 * Метод для удаления заказа по его идентификатору
	 * 
	 * @param id идентификатор заказа
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	void delete(int id) throws ServiceException;

	/**
	 * Метод для добавления и редактирования заказа
	 * 
	 * @param id идентификатор заказа
	 * @param userName имя пользователя, который редактирует заказ
	 * @param carId идентификатор автомобиля
	 * @param dateFrom дата начала заказа
	 * @param dateTo дата окончания заказа 
	 * @param comment комментарий пользователя к заказу
	 * @param passportNumber номер пасспорта пользователя
	 * @return идентификатор заказа
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	int modify(int id, String userName, int carId, Date dateFrom, Date dateTo, String comment, String passportNumber)
			throws ServiceException;

	/**
	 * Метод подтверждения заказа
	 * 
	 * @param id идентификатор заказа
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	void confirm(int id) throws ServiceException;

	/**
	 * Метод для завершения заказа
	 * 
	 * @param id идентификатор заказа
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	void complete(int id) throws ServiceException;

	/**
	 * Метод для отмены заказа
	 * 
	 * @param id идентификатор заказа 
	 * @param cancelReason
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	void cancel(int id, String cancelReason) throws ServiceException;

	/**
	 * Метод для оплаты заказа
	 * 
	 * @param id идентификатор заказа
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	void pay(int id) throws ServiceException;

	/**
	 * Метод для добовления повреждения автомобиля
	 * 
	 * @param id идентификатор заказа
	 * @param cost стоимость ремонта
	 * @param description описание повреждения
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	void addDamage(int id, float cost, String description) throws ServiceException;

	/**
	 * Метод для проверки того, что пользователь имеет право редактировать этот заказ
	 * 
	 * @param nickname ник пользователя
	 * @param dealId идентификатор заказа
	 * @return результат проверки
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	boolean checkUser(String nickname, int dealId) throws ServiceException;

	/**
	 * Метод для проверки того, что автомобиль для указанных дат свободен
	 * 
	 * @param id идентификатор автомобиля
	 * @param dateFrom дата начала проката
	 * @param dateTo дата окончания проката 
	 * @return результат проверки
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	boolean checkScheduleCar(int id, Date dateFrom, Date dateTo) throws ServiceException;
}
