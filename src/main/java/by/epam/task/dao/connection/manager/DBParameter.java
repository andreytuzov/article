package by.epam.task.dao.connection.manager;

/**
 * Класс ключей к файлу конфигурации соединения с базой данных 
 */
public class DBParameter {
	private DBParameter() {}
	
	/** Ключ определяет имя базы данных */
	public static final String DATABASE_USERNAME = "database.username";
	/** Ключ определяет пароль базы данны */
	public static final String DATABASE_PASSWORD = "database.password";
	/** Ключ определяет драйвер для соединения с базой данных */
	public static final String DATABASE_DRIVER = "database.driver";
	/** Ключ определяет путь к базе данных */
	public static final String DATABASE_URL = "database.url";
	/** Ключ определяет размер пула соединений */
	public static final String DATABASE_POOLSIZE = "database.poolsize";
}
