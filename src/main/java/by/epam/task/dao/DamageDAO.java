package by.epam.task.dao;

import by.epam.task.dao.exception.DAOException;
import by.epam.task.domain.Damage;

public interface DamageDAO {

	int delete(int id) throws DAOException;
	
	int insert(Damage damage) throws DAOException;
	
	int update(Damage damage) throws DAOException;	
}
