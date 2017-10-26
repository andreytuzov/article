package by.epam.task.service;

import java.util.Date;
import java.util.List;

import by.epam.task.domain.Deal;
import by.epam.task.service.exception.ServiceException;

public interface DealService {

	Deal findOne(int id) throws ServiceException;
	
	Deal findOneByNickname(String nickname) throws ServiceException;

	List<Deal> findAll() throws ServiceException;

	void delete(int id) throws ServiceException;

	int modify(int id, String userName, int carId, Date dateFrom, Date dateTo, String comment) throws ServiceException;

	void confirm(int id) throws ServiceException;

	void cancel(int id, String cancelReason) throws ServiceException;
	
	void pay(int id) throws ServiceException;
	
	int addDamage(int id, float bill, String description) throws ServiceException;
}
