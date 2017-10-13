package by.epam.task.dao.scheme;

public class CarSQL {
	private CarSQL() {}
	
	public static final String TABLE_CARS = "cars";
	
	public static final String CAR_ID = "id";
	public static final String CAR_MODEL = "model";
	public static final String CAR_VOLUME = "volume";
	public static final String CAR_POWER = "power";
	public static final String CAR_YEAR = "year";
	public static final String CAR_DISCOUNT_ID = "discount_id";
	public static final String CAR_PRISE = "prise";
	public static final String CAR_DESCRIPTION = "description";
	
	public static final String SELECT_CARS = "SELECT * FROM " + TABLE_CARS;
	public static final String SELECT_CAR_BY_ID = "SELECT * FROM " + TABLE_CARS 
			+ " WHERE " + CAR_ID + " = :" + CAR_ID;
	public static final String INSERT_CAR = 
			"INSERT INTO " + TABLE_CARS + "(" + CAR_DESCRIPTION 
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
	public static final String DELETE_CAR = "SELECT * from " + TABLE_CARS
			+ " WHERE " + CAR_ID + " = :" + CAR_ID;
	public static final String DELETE_LIST_CARS = "SELECT * FROM " + TABLE_CARS
			+ " WHERE " + CAR_ID + " IN (:" + CAR_ID + ")";
	public static final String UPDATE_CAR = 
			"UPDATE " + TABLE_CARS + " SET " + CAR_DESCRIPTION + " = :" + CAR_DESCRIPTION 
				+ ", " + CAR_DISCOUNT_ID + " = :" + CAR_DISCOUNT_ID
				+ ", " + CAR_MODEL + " = :" + CAR_MODEL
				+ ", " + CAR_POWER + " = :" + CAR_POWER
				+ ", " + CAR_PRISE + " = :" + CAR_PRISE
				+ ", " + CAR_VOLUME + " = :" + CAR_VOLUME
				+ ", " + CAR_YEAR + " = :" + CAR_YEAR
			+ " WHERE " + CAR_ID + " = :" + CAR_ID;
}
