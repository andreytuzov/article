package by.epam.task.dao.sql;

/**
 * Класс с sql-запросами для таблицы damages
 */
public class DamageSQL {
	private DamageSQL() {}
	
	/** Номер параметра: стоимость ремонта автомобиля */
	public static final int INDEX_DAMAGE_COST = 1;
	/** Номер параметра: описание повреждения */
	public static final int INDEX_DAMAGE_DESCRIPTION = 2;
	/** Номер параметра: внешний ключ на таблицу deals*/
	public static final int INDEX_DAMAGE_DEAL_ID = 3;
	 
	/** SQL-запрос для вставки записи в таблицу */
	public static final String INSERT_DAMAGE = "INSERT INTO damages(dmg_cost, dmg_description, dmg_deal_id)" 
			+ " VALUES(?, ?, ?)";
	/** SQL-запрос для удаления записи из таблицы */
	public static final String DELETE_DAMAGE = "SELECT * FROM damages WHERE dmg_id = ?";
	/** SQL-запрос обновления записи в таблице */
	public static final String UPDATE_DAMAGE = "UPDATE damages "
			+ " SET dmg_cost = ?, dmg_description = ?"
			+ " WHERE dmg_id = ?";
	
}
