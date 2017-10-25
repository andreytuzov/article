package by.epam.task.dao.sql;

public class DealSQL {
	private DealSQL() {}
		
	public static final int INDEX_USER_NICKNAME = 1;
	
	public static final int INDEX_DEAL_ID = 1;
	public static final int INDEX_DEAL_ID_UPDATE = 9;
	
	public static final int INDEX_DEAL_USER_ID = 1;
	public static final int INDEX_DEAL_CAR_ID = 2;
	public static final int INDEX_DEAL_DEAL_STATE_ID = 3;
	public static final int INDEX_DEAL_BILL = 4;
	public static final int INDEX_DEAL_DATE_FROM = 5;
	public static final int INDEX_DEAL_DATE_TO = 6;
	public static final int INDEX_DEAL_DESCRIPTION = 7;
	public static final int INDEX_DEAL_CANCEL_REASON = 8;
	
	
	public static final String SELECT_DEALS = "SELECT * FROM deals d, deal_states ds, users u, cars c, damages dmg" + 
			" WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND d.d_id = dmg.dmg_deal_id";
	public static final String SELECT_DEAL_BY_NICKNAME = "SELECT * FROM deals d, deal_states ds, users u, cars c, damages dmg" + 
			" WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND d.d_id = dmg.dmg_deal_id and u.u_nickname = ?"; 
	public static final String SELECT_DEAL_BY_ID = "SELECT * FROM deals d, deal_states ds, users u, cars c, damages dmg" + 
			" WHERE d.d_user_id = u.u_id AND d.d_car_id = c.c_id AND d.d_deal_state_id = ds.ds_id AND d.d_id = dmg.dmg_deal_id and d.id = ?"; 
	public static final String INSERT_DEAL = "INSERT INTO deals(d_user_id, d_car_id, d_deal_state_id, d_bill, d_date_from, d_date_to, d_description, d_cancel_reason)" 
			+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String DELETE_DEAL = "SELECT * FROM deals WHERE d_id = ?";
	public static final String UPDATE_DEAL = "UPDATE deals "
			+ " SET d_user_id = ?, d_car_id = ?, d_deal_state_id = ?, d_bill = ?, d_date_from = ?, d_date_to = ?, d_description = ?, d_cancel_reason = ?"
			+ " WHERE d_id = ?";
	
	
}
