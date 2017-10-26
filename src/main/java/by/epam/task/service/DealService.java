package by.epam.task.service;

import java.util.Date;
import java.util.List;

import by.epam.task.domain.Deal;
import by.epam.task.service.exception.ServiceException;

public interface DealService {

	Deal findOne(int id) throws ServiceException;
	
	List<Deal> findAllByNickname(String nickname) throws ServiceException;

	List<Deal> findAll() throws ServiceException;

	void delete(int id) throws ServiceException;

	int modify(int id, String userName, int carId, Date dateFrom, Date dateTo, String comment, String passportNumber) throws ServiceException;

	void confirm(int id) throws ServiceException;
	
	void complete(int id) throws ServiceException;

	void cancel(int id, String cancelReason) throws ServiceException;
	
	void pay(int id) throws ServiceException;
	
	void addDamage(int id, float cost, String description) throws ServiceException;
	
	boolean checkUser(String nickname, int dealId) throws ServiceException;
}
