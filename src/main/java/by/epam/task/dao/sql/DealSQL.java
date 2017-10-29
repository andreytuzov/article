package by.epam.task.dao.sql;

public class DealSQL {
	private DealSQL() {}
		
	public static final int INDEX_USER_NICKNAME = 1;
	public static final int INDEX_DEAL_DEAL_STATE_ID_SELECT = 1;
	
	public static final int INDEX_DEAL_ID = 1;
	public static final int INDEX_DEAL_ID_UPDATE = 10;
	
	public static final int INDEX_DEAL_CAR_ID = 1;
	public static final int INDEX_DEAL_DATE_FROM = 2;
	public static final int INDEX_DEAL_DATE_TO = 3;
	public static final int INDEX_DEAL_USER_ID = 4;
	public static final int INDEX_DEAL_DEAL_STATE_ID = 5;
	public static final int INDEX_DEAL_COST = 6;
	public static final int INDEX_DEAL_DESCRIPTION = 7;
	public static final int INDEX_DEAL_CANCEL_REASON = 8;
	public static final int INDEX_DEAL_PASSWORD_NUMBER = 9;
	
	public static final String SELECT_DEALS = "SELECT * FROM deals d LEFT JOIN damages dmg ON d.d_id = dmg.dmg_deal_id, deal_states ds, users u, cars c" 
			+ " WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id";
	public static final String SELECT_DEAL_BY_CAR_AFTER_NOW = "SELECT * FROM deals d LEFT JOIN damages dmg ON d.d_id = dmg.dmg_deal_id, deal_states ds, users u, cars c" 
			+ " WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND d.d_date_to > NOW() AND d.d_car_id = ?";
	public static final String SELECT_DEAL_BY_CAR_BETWEEN_DATE = "SELECT * FROM deals d LEFT JOIN damages dmg ON d.d_id = dmg.dmg_deal_id, deal_states ds, users u, cars c" 
			+ " WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND d.d_car_id = ? AND (? BETWEEN d.d_date_from AND d.d_date_to) AND (? BETWEEN d.d_date_from AND d.d_date_to)";
	public static final String SELECT_DEAL_BY_NICKNAME = "SELECT * FROM deals d LEFT JOIN damages dmg ON d.d_id = dmg.dmg_deal_id, deal_states ds, users u, cars c" 
			+ " WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND u.u_nickname = ?";
	public static final String SELECT_DEAL_BY_DEALSTATE = "SELECT * FROM deals d LEFT JOIN damages dmg ON d.d_id = dmg.dmg_deal_id, deal_states ds, users u, cars c" 
			+ " WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND ds.ds_id = ?";
	public static final String SELECT_DEAL_BY_ID = "SELECT * FROM deals d LEFT JOIN damages dmg ON d.d_id = dmg.dmg_deal_id, deal_states ds, users u, cars c" 
			+ " WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND d.d_id = ?";
	public static final String INSERT_DEAL = "INSERT INTO deals(d_car_id, d_date_from, d_date_to, d_user_id, d_deal_state_id, d_cost, d_comment, d_cancel_reason, d_passport_number)" 
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String DELETE_DEAL = "DELETE FROM deals WHERE d_id = ?";
	public static final String UPDATE_DEAL = "UPDATE deals "
			+ " SET d_car_id = ?, d_date_from = ?, d_date_to = ?, d_user_id = ?, d_deal_state_id = ?, d_cost = ?, d_comment = ?, d_cancel_reason = ?, d_passport_number = ?"
			+ " WHERE d_id = ?";
	
	
}
