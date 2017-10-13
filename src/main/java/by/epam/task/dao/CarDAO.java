package by.epam.task.dao;

import java.util.List;

import by.epam.task.dao.exception.DaoException;
import by.epam.task.domain.Car;

public interface CarDAO {
	Car findOne(int id) throws DaoException;

	List<Car> findAll() throws DaoException;

	int delete(int id) throws DaoException;

	int delete(List<Integer> listID) throws DaoException;
		
	int saveOrUpdate(Car car) throws DaoException;
}
