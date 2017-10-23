package by.epam.task.dao;

import java.util.List;

import by.epam.task.dao.exception.DAOException;
import by.epam.task.domain.Deal;

public interface DealDAO {
	Deal findOneByNickname(String nickname) throws DAOException;

	List<Deal> findAll() throws DAOException;

	int delete(int id) throws DAOException;
		
	int insert(Deal deal) throws DAOException;
	
	int update(Deal deal) throws DAOException;	
}
