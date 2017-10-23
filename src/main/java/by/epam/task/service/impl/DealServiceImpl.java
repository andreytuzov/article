package by.epam.task.service.impl;

import java.util.List;

import by.epam.task.dao.DealDAO;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.factory.DAOFactory;
import by.epam.task.domain.Deal;
import by.epam.task.service.DealService;
import by.epam.task.service.exception.ServiceException;

public class DealServiceImpl implements DealService {
	
	private final DealDAO dealDAO = DAOFactory.getInstance().getDealDAO();
	
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
	public int saveOrUpate(Deal deal) throws ServiceException {
		int id = deal.getId();
		try {
			if (id == 0) {
				id = dealDAO.insert(deal);
			} else {
				dealDAO.update(deal);
			}
			if (id == 0) {
				throw new ServiceException("Save or update error");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error executing the saveOrUpdate method", e);
		}
		return id;
	}

}
