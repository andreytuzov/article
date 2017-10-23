package by.epam.task.dao;

import java.util.List;

import by.epam.task.dao.exception.DAOException;
import by.epam.task.domain.Car;

public interface CarDAO {
	Car findOne(int id) throws DAOException;

	List<Car> findAll() throws DAOException;

	int delete(int id) throws DAOException;

	int delete(List<Integer> listID) throws DAOException;

	int insert(Car car) throws DAOException;

	int update(Car car) throws DAOException;
}
