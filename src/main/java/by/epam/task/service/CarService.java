package by.epam.task.service;

import java.util.List;

import by.epam.task.domain.Car;
import by.epam.task.service.exception.ServiceException;

/**
 * Интерфейс, содержащий функции для работы с объектом бизнес данных Car 
 */
public interface CarService {
	
	/**
	 * Метод для получения объекта автомобиля по указанному идентификатору
	 * 
	 * @param id идентификатор автомобиля
	 * @return объект автомобиля
	 * @throws ServiceException возникает при ошибке во время выполнения метода
	 */
	Car findOne(int id) throws ServiceException;

	/**
	 * Метод для получения списка всех автомобилей
	 * 
	 * @return список автомобилей
	 * @throws ServiceException при ошибке во время выполнения метода
	 */
	List<Car> findAll() throws ServiceException;

	/**
	 * Метод для удаления автомобиля по указанному идентификатору
	 * 
	 * @param id идентификатор автомобиля
	 * @throws ServiceException при ошибке во время выполнения метода
	 */
	void delete(int id) throws ServiceException;

	/**
	 * Метод для удаления автомобилей по указанному списку идентификаторов 
	 * 
	 * @param listID список идентификаторов автомобилей
	 * @throws ServiceException при ошибке во время выполнения метода
	 */
	void delete(List<Integer> listID) throws ServiceException;
		
	/**
	 * Метод для добавления и редактирования автомобиля  
	 * 
	 * @param car объект автомобиля
	 * @return идентификатор автомобиля
	 * @throws ServiceException при ошибке во время выполнения метода
	 */
	int modify(Car car) throws ServiceException;
}
