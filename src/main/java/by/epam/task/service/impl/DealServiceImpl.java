package by.epam.task.service.impl;

import java.util.Date;
import java.util.List;

import by.epam.task.dao.CarDAO;
import by.epam.task.dao.DamageDAO;
import by.epam.task.dao.DealDAO;
import by.epam.task.dao.UserDAO;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.factory.DAOFactory;
import by.epam.task.domain.Car;
import by.epam.task.domain.Damage;
import by.epam.task.domain.Deal;
import by.epam.task.domain.DealState;
import by.epam.task.domain.User;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;

public class DealServiceImpl implements DealService {
	
	private final DealDAO dealDAO = DAOFactory.getInstance().getDealDAO();
	
	@Override
	public Deal findOne(int id) throws ServiceException {
		Deal deal = null;
		try {
			deal = dealDAO.findOne(id);
		} catch (DAOException e) {
			throw new ServiceException("Error execution findOneByNickname method", e);
		}
		return deal;
	}
	
	@Override
	public Deal findOneByNickname(String nickname) throws ServiceException {
		Deal deal = null;
		try {
			deal = dealDAO.findOneByNickname(nickname);
		} catch (DAOException e) {
			throw new ServiceException("Error execution findOneByNickname method", e);
		}
		return deal;
	}

	@Override
	public List<Deal> findAll() throws ServiceException {
		List<Deal> list = null;
		try {
			list = dealDAO.findAll();
		} catch (DAOException e) {
			throw new ServiceException("Error execution findAll method", e);
		}
		return list;
	}

	@Override
	public void delete(int id) throws ServiceException {
		try {
			int count = dealDAO.delete(id);
			if (count == 0) {
				throw new ServiceException("Delete error");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error execution delete method", e);
		}
	}

	@Override
	public int modify(int id, int userId, int carId, Date dateFrom, Date dateTo, String description) throws ServiceException {
		CarDAO carDAO = DAOFactory.getInstance().getCarDAO();
		UserDAO userDAO = DAOFactory.getInstance().getUserDAO();
		try {
			// Data validation
			Car car = carDAO.findOne(carId);
			User user = userDAO.findOne(userId);
			if (car == null || user == null) {
				throw new ServiceException("Incorrect identificators");
			}
			// Creating deal
			float bill = (dateTo.getTime() - dateFrom.getTime()) / 3600000 * car.getPrise();
			Deal deal = new Deal(id, bill, dateFrom, dateTo, description, null, 
					new User(userId), new Car(carId), null, DealState.CREATED);	
			if (id == 0) {
				id = dealDAO.insert(deal);
			} else {
				dealDAO.update(deal);
			}
			if (id == 0) {
				throw new ServiceException("insert or update error");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error executing the saveOrUpdate method", e);
		}
		return id;
	}

	@Override
	public void confirm(int id) throws ServiceException {
		try {
			Deal deal = dealDAO.findOne(id);
			// Data validation
			if (deal == null || deal.getState() != DealState.CREATED) {
				throw new ServiceException("Incorrect state of deal");
			}
			deal.setState(DealState.CONFIRMED);
			dealDAO.update(deal);
		} catch (DAOException e) {
			throw new ServiceException("Error execution confirmDeal method", e);
		}
	}
	
	@Override
	public void cancel(int id, String reason) throws ServiceException {
		try {
			Deal deal = dealDAO.findOne(id);
			// Data validation
			if (deal == null || deal.getState() != DealState.CREATED) {
				throw new ServiceException("Incorrect state of deal");
			}
			deal.setState(DealState.CANCELED);
			deal.setReason(reason);
			dealDAO.update(deal);
		} catch (DAOException e) {
			throw new ServiceException("Error execution confirmDeal method", e);
		}
	}

	@Override
	public void pay(int id) throws ServiceException {
		try {
			Deal deal = dealDAO.findOne(id);
			// Data validation
			if (deal == null || !(deal.getState() == DealState.CONFIRMED || deal.getState() == DealState.DAMAGED)) {
				throw new ServiceException("Incorrect state of deal");
			}
			if (deal.getState() == DealState.CONFIRMED) {
				deal.setState(DealState.PAID);
			} else {
				deal.setState(DealState.COMPLETED);
			}
			dealDAO.update(deal);
		} catch (DAOException e) {
			throw new ServiceException("Error execution payDeal method", e);
		}
	}
	
	@Override
	public int addDamage(int id, float bill, String description) throws ServiceException {
		DamageDAO damageDAO = DAOFactory.getInstance().getDamageDAO();
		Damage damage = new Damage(id, bill, description);
		try {
			if (id == 0) {
				id = damageDAO.insert(damage);
			} else {
				damageDAO.update(damage);
			}
			if (id == 0) {
				throw new ServiceException("Save or update error");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error executing the addDamage method", e);
		}
		return id;
	}

}
