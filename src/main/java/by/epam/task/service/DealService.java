package by.epam.task.service;

import java.util.List;

import by.epam.task.domain.Deal;
import by.epam.task.service.exception.ServiceException;

public interface DealService {
	Deal findOneByNickname(String nickname) throws ServiceException;

	List<Deal> findAll() throws ServiceException;

	void delete(int id) throws ServiceException;
		
	int saveOrUpate(Deal deal) throws ServiceException;
}
 