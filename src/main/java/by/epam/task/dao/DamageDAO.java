package by.epam.task.dao;

import by.epam.task.dao.exception.DAOException;
import by.epam.task.domain.Damage;

/**
 * Интерфейс, содержащий функции для работы с таблицей damages 
 */
public interface DamageDAO {	

	/**
	 * Метод для добавления в таблицу повреждения
	 * 
	 * @param damage объект повреждения
	 * @throws DAOException возникает при ошибке во время выполнения функции
	 */
	void insert(Damage damage) throws DAOException;
}
