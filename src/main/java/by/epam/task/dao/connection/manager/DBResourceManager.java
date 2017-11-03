package by.epam.task.dao.connection.manager;

import java.util.ResourceBundle;

/**
 * Менеджер для получения параметров соединения с базой данных
 */
public class DBResourceManager {
	
	/** Объект для работы с файлом свойств database */
	private final ResourceBundle bundle;

	/**
	 * @param dbType тип базы данных
	 */
	public DBResourceManager(DBType dbType) {
		bundle = ResourceBundle.getBundle(dbType.getResourceName());
	}

	/**
	 * Метод для получения значения свойства ключа параметра
	 * 
	 * @param key ключ параметра
	 * @return значение параметра
	 */
	public String getValue(String key) {
		return bundle.getString(key);
	}
	
}
