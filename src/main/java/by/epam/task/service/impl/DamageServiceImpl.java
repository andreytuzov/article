package by.epam.task.service.impl;

import by.epam.task.dao.DamageDAO;
import by.epam.task.dao.exception.DAOException;
import by.epam.task.dao.factory.DAOFactory;
import by.epam.task.domain.Damage;
import by.epam.task.service.DamageService;
import by.epam.task.service.exception.ServiceException;

public class DamageServiceImpl implements DamageService {

	private final DamageDAO damageDAO = DAOFactory.getInstance().getDamageDAO();
	
	@Override
	public void delete(int id) throws ServiceException {
		try {
			int count = damageDAO.delete(id);
			if (count == 0) {
				throw new ServiceException("Delete error");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error execution delete method", e);
		}
	}

	@Override
	public int saveOrUpate(Damage damage) throws ServiceException {
		int id = damage.getId();
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
			throw new ServiceException("Error executing the saveOrUpdate method", e);
		}
		return id;
	}

}
