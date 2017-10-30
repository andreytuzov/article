package by.epam.task.dao.sql;

/**
 * Класс с sql-запросами для таблицы cars
 */
public class CarSQL {
	private CarSQL() {
	}

	/** Номер параметра: идентификатор автомобиля */
	public static final int INDEX_CAR_ID = 1;
	/** Номер параметра: идентификатор автомобиля при обновлении */
	public static final int INDEX_CAR_ID_UPDATE = 7;

	/** Номер параметра: описание автомобиля */
	public static final int INDEX_CAR_DESCRIPTION = 1;
	/** Номер параметра: модель автомобиля */
	public static final int INDEX_CAR_MODEL = 2;
	/** Номер параметра: мощность автомобиля */
	public static final int INDEX_CAR_POWER = 3;
	/** Номер параметра: цена автомобиля */
	public static final int INDEX_CAR_PRISE = 4;
	/** Номер параметра: объем двигателя автомобиля */
	public static final int INDEX_CAR_VOLUME = 5;
	/** Номер параметра: год выпуска автомобиля */
	public static final int INDEX_CAR_YEAR = 6;

	/** SQL-запрос для получения всех записей из таблицы */
	public static final String SELECT_CARS = "SELECT * FROM cars ORDER BY c_id DESC";
	/** SQL-запрос для получения записи из таблицы с указанным идентификатором  */
	public static final String SELECT_CAR_BY_ID = "SELECT * FROM cars WHERE c_id = ?";
	/** SQL-запрос для вставки записи в таблицу */
	public static final String INSERT_CAR = " INSERT INTO cars(c_description, c_model, c_power, c_prise, c_volume, c_year)"
			+ " VALUES(?, ?, ?, ?, ?, ?)";
	/** SQL-запрос для удаления автомобиля в таблице по указанному идентификатору */
	public static final String DELETE_CAR = "DELETE FROM cars WHERE c_id = ?";
	/** SQL-запрос для удаления записи в таблице по указанным идентификаторам */
	public static final String DELETE_LIST_CARS = "SELECT * FROM cars WHERE c_id IN (?)";
	/** SQL-запрос для обновления записи в таблице */
	public static final String UPDATE_CAR = "UPDATE cars"
			+ " SET c_description = ?, c_model = ?, c_power = ?, c_prise = ?, c_volume = ?, c_year = ?"
			+ " WHERE c_id = ?";
}
