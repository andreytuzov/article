package by.epam.task.dao.connection.manager;

/** 
 * Перечисление баз данных и используемых ресурсов с параметрами соединения с базами данных
 */
public enum DBType {
	/** Основная база данных*/
	DB_MAIN("database"),
	/** База данных для тестирования */
	DB_TEST("database_test");
	
	/** Имя ресурса с параметрами соединения с базой данных */
	private String resourceName;
	
	/**
	 * @param resouceName имя ресурса с параметрами соединения с базой данных
	 */
	DBType(String resouceName) {
		this.resourceName = resouceName;
	}
	
	public String getResourceName() {
		return resourceName;
	}
}
