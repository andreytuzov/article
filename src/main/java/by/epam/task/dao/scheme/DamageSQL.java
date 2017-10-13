package by.epam.task.dao.scheme;

public class DamageSQL {
	private DamageSQL() {}
	
	public static final String TABLE_DAMAGES = "damages";
	
	public static final String DAMAGE_DEAL_ID = "deal_id";
	public static final String DAMAGE_BILL = "bill";
	public static final String DAMAGE_DESCRIPTION = "description";
	
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
