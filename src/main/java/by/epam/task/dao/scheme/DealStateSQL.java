package by.epam.task.dao.scheme;

public class DealStateSQL {
	private DealStateSQL() {}
	
	public static final String TABLE_DEAL_STATES = "dead_states";
	
	public static final String DEAL_STATES_ID = "id";
	public static final String DEAL_STATES_NAME = "name";
	
	public static final String SELECT_CARS = "SELECT * FROM " + TABLE_CAR;
	public static final String SELECT_CAR_BY_ID = "SELECT * FROM " + TABLE_CAR 
			+ " WHERE " + CAR_ID + " = :" + CAR_ID;
	public static final String INSERT_CAR = 
			"INSERT INTO " + TABLE_CAR + "(" + CAR_DESCRIPTION 
				+ ", " + CAR_DISCOUNT_ID
				+ ", " + CAR_MODEL
				+ ", " + CAR_POWER
				+ ", " + CAR_PRISE
				+ ", " + CAR_VOLUME
				+ ", " + CAR_YEAR + ")"
			+ " VALUES(:" + CAR_DESCRIPTION
				+ ", :" + CAR_DISCOUNT_ID
				+ ", :" + CAR_MODEL
				+ ", :" + CAR_POWER
				+ ", :" + CAR_PRISE
				+ ", :" + CAR_VOLUME
				+ ", :" + CAR_YEAR + ")";
	public static final String DELETE_CAR = "SELECT * from " + TABLE_CAR
			+ " WHERE " + CAR_ID + " = :" + CAR_ID;
	public static final String DELETE_LIST_CARS = "SELECT * FROM " + TABLE_CAR
			+ " WHERE " + CAR_ID + " IN (:" + CAR_ID + ")";
	public static final String UPDATE_CAR = 
			"UPDATE " + TABLE_CAR + " SET " + CAR_DESCRIPTION + " = :" + CAR_DESCRIPTION 
				+ ", " + CAR_DISCOUNT_ID + " = :" + CAR_DISCOUNT_ID
				+ ", " + CAR_MODEL + " = :" + CAR_MODEL
				+ ", " + CAR_POWER + " = :" + CAR_POWER
				+ ", " + CAR_PRISE + " = :" + CAR_PRISE
				+ ", " + CAR_VOLUME + " = :" + CAR_VOLUME
				+ ", " + CAR_YEAR + " = :" + CAR_YEAR
			+ " WHERE " + CAR_ID + " = :" + CAR_ID;
}
