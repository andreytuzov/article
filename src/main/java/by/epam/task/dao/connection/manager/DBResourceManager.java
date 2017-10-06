package by.epam.task.dao.connection.manager;

import java.util.ResourceBundle;

public class DBResourceManager {
	private DBResourceManager() {}
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("database");
	
	public static String getValue(String key) {
		return bundle.getString(key);
	}
}
