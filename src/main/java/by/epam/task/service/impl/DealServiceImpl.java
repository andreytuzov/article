package by.epam.task.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

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
	
	private static final Logger logger = Logger.getLogger(DealServiceImpl.class);
	
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
	public List<Deal> findAllByNickname(String nickname) throws ServiceException {
		List<Deal> list = null;
		try {
			list = dealDAO.findAllByNickname(nickname);
		} catch (DAOException e) {
			throw new ServiceException("Error execution findOneByNickname method", e);
		}
		return list;
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
			Deal deal = dealDAO.findOne(id);
			if (deal == null || deal.getState() != DealState.CREATED) {
				throw new ServiceException("Incorrect state of deal");
			}
			int count = dealDAO.delete(id);
			if (count == 0) {
				throw new ServiceException("Delete error");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error execution delete method", e);
		}
	}
	
	@Override
	public int modify(int id, String nickname, int carId, Date dateFrom, Date dateTo, String comment, String passportNumber) throws ServiceException {
		try {
			CarDAO carDAO = DAOFactory.getInstance().getCarDAO();
			UserDAO userDAO = DAOFactory.getInstance().getUserDAO();			
			// Data validation
			Car car = carDAO.findOne(carId);
			User user = userDAO.findOneByNickname(nickname);
			if (car == null || user == null) {
				throw new ServiceException("Incorrect identificators");
			}
			// Check state
			if (id != 0) {
				Deal deal = dealDAO.findOne(id);
				if (deal.getState() != DealState.CREATED) {
					throw new ServiceException("The user does not have rights to edit deal");
				}
			}
			// Creating deal
			float cost =  car.getPrise() * (dateTo.getTime() - dateFrom.getTime()) / 3600000;
			Deal deal = new Deal(id, cost, dateFrom, dateTo, comment, null, 
					new User(user.getId()), new Car(carId), null, DealState.CREATED, passportNumber);
			if (id == 0) {
				id = dealDAO.insert(deal);
			} else {
				dealDAO.update(deal);
			}
			if (id == 0) {
				throw new ServiceException("insert or update error");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error executing the modify method", e);
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
	public void complete(int id) throws ServiceException {
		try {
			Deal deal = dealDAO.findOne(id);
			// Data validation
			if (deal == null || deal.getState() != DealState.PAID) {
				throw new ServiceException("Incorrect state of deal");
			}
			deal.setState(DealState.COMPLETED);
			dealDAO.update(deal);
		} catch (DAOException e) {
			throw new ServiceException("Error execution completeDeal method", e);
		}
	}
	
	@Override
	public void cancel(int id, String cancelReason) throws ServiceException {
		try {
			Deal deal = dealDAO.findOne(id);
			// Data validation
			if (deal == null || deal.getState() != DealState.CREATED) {
				throw new ServiceException("Incorrect state of deal");
			}
			deal.setState(DealState.CANCELED);
			deal.setCancelReason(cancelReason);
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
	public void addDamage(int id, float cost, String description) throws ServiceException {
		DamageDAO damageDAO = DAOFactory.getInstance().getDamageDAO();
		Damage damage = new Damage(id, cost, description);
		try {
			Deal deal = dealDAO.findOne(id);
			// Data validation
			if (deal == null || deal.getState() != DealState.PAID) {
				throw new ServiceException("Incorrect state of deal");
			}
			deal.setState(DealState.DAMAGED);
			dealDAO.update(deal);
			damageDAO.insert(damage);
		} catch (DAOException e) {
			throw new ServiceException("Error executing the addDamage method", e);
		}
	}
	
	@Override
	public boolean checkUser(String nickname, int dealId) throws ServiceException {
		Deal deal = null;
		try {
			deal = dealDAO.findOne(dealId);
		} catch (DAOException e) {
			throw new ServiceException("Error execution the checkUser command", e);
		}
		// Data validation
		if (deal == null || !deal.getUser().getNickname().equals(nickname)) {
			return false;
		}
		return true;
	}

}
