package by.epam.task.dao.scheme;

public class DiscountSQL {
	private DiscountSQL() {}
	
	public static final String TABLE_DISCOUNTS = "discountes";
	
	public static final String DISCOUNTES_ID = "id";
	public static final String DISCOUNTES_NAME = "name";
	public static final String DISCOUNTES_ONLY_1_DAY = "only1day";
	public static final String DISCOUNTES_BETWEEN_2_AND_7_DAYS = "between2and7days";
	public static final String DISCOUNTES_BETWEEN_8_AND_15_DAYS = "between8and15days";
	public static final String DISCOUNTES_BETWEEN_16_AND_30_DAYS = "between16and30days";
	public static final String DISCOUNTES_FROM_31_DAYS = "from31days";
	
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
