package by.epam.task.dao;

import java.util.List;

import by.epam.task.dao.exception.DAOException;
import by.epam.task.domain.Car;

/**
 * Интерфейс, содержащий функции для работы с таблицей cars
 */
public interface CarDAO {
	/**
	 * Метод для получения автомобиля по указанному идентификатору
	 * 
	 * @param id идентификатор автомобиля
	 * @return автомобиль
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	Car findOne(int id) throws DAOException;

	/**
	 * Метод для получения списка всех автомобилей
	 * 
	 * @return список автомобилей
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	List<Car> findAll() throws DAOException;

	/**
	 * Метод для удаления автомобиля по указанному идентификатору
	 * 
	 * @param id идентификатор автомобиля
	 * @return количество удаленных записей
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	int delete(int id) throws DAOException;

	/**
	 * Метод для удаления автомобилей по указанному списку идентификаторов
	 * 
	 * @param listID список идентификаторов автомобиля
	 * @return количество удаленных записей
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	int delete(List<Integer> listID) throws DAOException;

	/**
	 * Метод для вставки автомобиля
	 * 
	 * @param car объект автомобиля 
	 * @return идентификатор добавленного автомобиля
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	int insert(Car car) throws DAOException;

	/**
	 * Метод для обновления автомобиля
	 * 
	 * @param car объект автомобиля
	 * @return идентификатор обновленного автомобиля
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	int update(Car car) throws DAOException;
}
