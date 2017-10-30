package by.epam.task.dao.connection.manager;

import java.util.ResourceBundle;

/**
 * Менеджер для получения параметров соединения с базой данных
 */
public class DBResourceManager {
	private DBResourceManager() {
	}

	/** Объект для работы с файлом свойств database */
	private static final ResourceBundle bundle = ResourceBundle.getBundle("database");

	/**
	 * Метод для получения значения свойства ключа параметра
	 * 
	 * @param key ключ параметра
	 * @return значение параметра
	 */
	public static String getValue(String key) {
		return bundle.getString(key);
	}
}
