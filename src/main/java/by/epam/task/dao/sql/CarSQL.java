package by.epam.task.dao.sql;

public class CarSQL {
	private CarSQL() {
	}

	public static final int INDEX_CAR_ID = 1;
	public static final int INDEX_CAR_ID_UPDATE = 7;

	public static final int INDEX_CAR_DESCRIPTION = 1;
	public static final int INDEX_CAR_MODEL = 2;
	public static final int INDEX_CAR_POWER = 3;
	public static final int INDEX_CAR_PRISE = 4;
	public static final int INDEX_CAR_VOLUME = 5;
	public static final int INDEX_CAR_YEAR = 6;

	public static final String SELECT_CARS = "SELECT * FROM cars ORDER BY c_id DESC";
	public static final String SELECT_CAR_BY_ID = "SELECT * FROM cars WHERE c_id = ?";
	public static final String INSERT_CAR = " INSERT INTO cars(c_description, c_model, c_power, c_prise, c_volume, c_year)"
			+ " VALUES(?, ?, ?, ?, ?, ?)";
	public static final String DELETE_CAR = "DELETE FROM cars WHERE c_id = ?";
	public static final String DELETE_LIST_CARS = "SELECT * FROM cars WHERE c_id IN (?)";
	public static final String UPDATE_CAR = "UPDATE cars"
			+ " SET c_description = ?, c_model = ?, c_power = ?, c_prise = ?, c_volume = ?, c_year = ?"
			+ " WHERE c_id = ?";
}
