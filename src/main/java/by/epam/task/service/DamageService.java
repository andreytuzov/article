package by.epam.task.service;

import by.epam.task.domain.Damage;
import by.epam.task.service.exception.ServiceException;

public interface DamageService {
	void delete(int id) throws ServiceException;
	
	int saveOrUpate(Damage damage) throws ServiceException;
}
