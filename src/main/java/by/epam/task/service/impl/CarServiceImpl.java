package by.epam.task.service.impl;

import java.util.List;

import by.epam.task.dao.CarDAO;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.factory.DAOFactory;
import by.epam.task.domain.Car;
import by.epam.task.service.CarService;
import by.epam.task.service.exception.ServiceException;

public class CarServiceImpl implements CarService {

	private final CarDAO carDAO = DAOFactory.getInstance().getCarDAO();
	
	@Override
	public Car findOne(int id) throws ServiceException {
		Car car = null;
		try {
			car = carDAO.findOne(id);
			if (car == null) {
				throw new ServiceException("The car was not found");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error execution the findOne method", e);
		}
		return car;
	}

	@Override
	public List<Car> findAll() throws ServiceException {
		List<Car> list = null;
		try {
			list = carDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Error execution the findAll method", e);
		}
		return list;
	}
	
	@Override
	public void delete(int id) throws ServiceException {
		try {
			int count = carDAO.delete(id);
			if (count == 0) {
				throw new ServiceException("Delete error");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error execution the delete method", e);
		}
	}

	@Override
	public void delete(List<Integer> listID) throws ServiceException {
		try {
			int count = carDAO.delete(listID);
			if (count == 0) {
				throw new ServiceException("Delete error");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error execution the delete method", e);
		}
	}

	@Override
	public int modify(Car car) throws ServiceException {
		int id = car.getId();
		try {
			if (id == 0 || null == carDAO.findOne(id)) {
				id = carDAO.insert(car);
			} else {
				carDAO.update(car);
			}
			if (id == 0) {
				throw new ServiceException("Save or update error");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error executing the modify method", e);
		}
		return id;
	}

}
