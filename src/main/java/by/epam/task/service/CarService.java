package by.epam.task.service;

import java.util.List;

import by.epam.task.domain.Car;
import by.epam.task.service.exception.ServiceException;

public interface CarService {
	Car findOne(int id) throws ServiceException;

	List<Car> findAll() throws ServiceException;

	void delete(int id) throws ServiceException;

	void delete(List<Integer> listID) throws ServiceException;
		
	int saveOrUpdate(Car car) throws ServiceException;
}
