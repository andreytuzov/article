package by.epam.task.dao.sql;

/**
 * Класс с sql-запросами для таблицы deal
 */
public class DealSQL {
	private DealSQL() {}
		
	/** Номер параметра: ник пользователя */
	public static final int INDEX_USER_NICKNAME = 1;
	/** Номер параметра: внешний ключ на таблицу состояний заказов (deal_states) в запросе select */
	public static final int INDEX_DEAL_DEAL_STATE_ID_SELECT = 1;
	
	/** Номер параметра: первичный ключ */
	public static final int INDEX_DEAL_ID = 1;
	/** Номер параметра: первичный ключ в запросе обновления */
	public static final int INDEX_DEAL_ID_UPDATE = 10;
	
	/** Номер параметра: внешний ключ на таблицу автомобилей (cars)*/
	public static final int INDEX_DEAL_CAR_ID = 1;
	/** Номер параметра: время начала проката автомобиля */
	public static final int INDEX_DEAL_DATE_FROM = 2;
	/** Номер параметра: время окончания проката автомобиля */
	public static final int INDEX_DEAL_DATE_TO = 3;
	/** Номер параметра: внешний ключ на таблице пользователей (users)*/
	public static final int INDEX_DEAL_USER_ID = 4;
	/** Номер параметра: внешний ключ на таблицу состояний заказов (deal_states) */
	public static final int INDEX_DEAL_DEAL_STATE_ID = 5;
	/** Номер параметра: стоимость проката автомобиля за час */
	public static final int INDEX_DEAL_COST = 6;
	/** Номер параметра: описание заказа */
	public static final int INDEX_DEAL_DESCRIPTION = 7;
	/** Номер параметра: комментарий пользователя к заказу */
	public static final int INDEX_DEAL_CANCEL_REASON = 8;
	/** Номер параметра: номер паспорта */
	public static final int INDEX_DEAL_PASSWORD_NUMBER = 9;
	
	/** SQL-запрос для получения всех записей из таблицы */
	public static final String SELECT_DEALS = "SELECT * FROM deals d LEFT JOIN damages dmg ON d.d_id = dmg.dmg_deal_id, deal_states ds, users u, cars c" 
			+ " WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id";
	/** SQL-запрос для получения актуальных записей из таблицы для указанного автомобиля */
	public static final String SELECT_DEAL_BY_CAR_AFTER_NOW = "SELECT * FROM deals d LEFT JOIN damages dmg ON d.d_id = dmg.dmg_deal_id, deal_states ds, users u, cars c" 
			+ " WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND d.d_date_to > NOW() AND d.d_car_id = ?";
	/** SQL-запрос для получения записей из таблицы для выбранного автомобиля, которые пересекаются с указанным интервалом */
	public static final String SELECT_DEAL_BY_CAR_BETWEEN_DATE = "SELECT * FROM deals d LEFT JOIN damages dmg ON d.d_id = dmg.dmg_deal_id, deal_states ds, users u, cars c" 
			+ " WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND d.d_car_id = ? AND (? BETWEEN d.d_date_from AND d.d_date_to) AND (? BETWEEN d.d_date_from AND d.d_date_to)";
	/** SQL-запрос для получения записей из таблицы для указанного пользователя */
	public static final String SELECT_DEAL_BY_NICKNAME = "SELECT * FROM deals d LEFT JOIN damages dmg ON d.d_id = dmg.dmg_deal_id, deal_states ds, users u, cars c" 
			+ " WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND u.u_nickname = ?";
	/** SQL-запрос для получения записей из таблицы для указанного состояния заказа */
	public static final String SELECT_DEAL_BY_DEALSTATE = "SELECT * FROM deals d LEFT JOIN damages dmg ON d.d_id = dmg.dmg_deal_id, deal_states ds, users u, cars c" 
			+ " WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND ds.ds_id = ?";
	/** SQL-запрос для получения записи из таблицы по идентификатору */
	public static final String SELECT_DEAL_BY_ID = "SELECT * FROM deals d LEFT JOIN damages dmg ON d.d_id = dmg.dmg_deal_id, deal_states ds, users u, cars c" 
			+ " WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND d.d_id = ?";
	/** SQL-запрос для вставки записи в таблицу */
	public static final String INSERT_DEAL = "INSERT INTO deals(d_car_id, d_date_from, d_date_to, d_user_id, d_deal_state_id, d_cost, d_comment, d_cancel_reason, d_passport_number)" 
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	/** SQL-запрос для удаления записи из таблицы */
	public static final String DELETE_DEAL = "DELETE FROM deals WHERE d_id = ?";
	/** SQL-запрос для обновления записи в таблице */
	public static final String UPDATE_DEAL = "UPDATE deals "
			+ " SET d_car_id = ?, d_date_from = ?, d_date_to = ?, d_user_id = ?, d_deal_state_id = ?, d_cost = ?, d_comment = ?, d_cancel_reason = ?, d_passport_number = ?"
			+ " WHERE d_id = ?";
}
