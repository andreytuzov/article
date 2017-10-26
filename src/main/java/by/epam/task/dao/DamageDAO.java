package by.epam.task.dao;

import by.epam.task.dao.exception.DAOException;
import by.epam.task.domain.Damage;

public interface DamageDAO {	
	
	void insert(Damage damage) throws DAOException;
	
}
