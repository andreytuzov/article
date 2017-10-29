package by.epam.task.dao;

import java.util.Date;
import java.util.List;

import by.epam.task.dao.exception.DAOException;
import by.epam.task.domain.Deal;
import by.epam.task.domain.DealState;

public interface DealDAO {
	
	Deal findOne(int id) throws DAOException;
	
	List<Deal> findAllByNickname(String nickname) throws DAOException;

	List<Deal> findAllByDealState(DealState dealState) throws DAOException;
	
	List<Deal> findAllByCarAfterNow(int id) throws DAOException;
	
	List<Deal> findAllByCarBetweenDate(int id, Date dateFrom, Date dateTo) throws DAOException;
	
	List<Deal> findAll() throws DAOException;

	int delete(int id) throws DAOException;
		
	int insert(Deal deal) throws DAOException;
	
	int update(Deal deal) throws DAOException;
}
