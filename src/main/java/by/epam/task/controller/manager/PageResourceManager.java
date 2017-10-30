package by.epam.task.controller.manager;

import java.util.ResourceBundle;

/**
 * Менеджер для получения url адресов или расположения jsp-страниц по ключу 
 */
public class PageResourceManager {
	
	private PageResourceManager() {}
	
	/** Объект для работы с файлом свойств page */
	private static final ResourceBundle bundle = ResourceBundle.getBundle("page");
	
	/** Префикс пути к jsp-странице */
	public static final String PREFIX_PATH = "/WEB-INF/views/pages/";
	
	/** Суфикс пути к jsp-странице */
	public static final String EXTENSION = ".jsp";
	
	/** Разделитель запросов */
	public static final String DELIMITER = "&";
	
	/**
	 * Метод для получения расположения jsp-страницы по ее имени 
	 *  
	 * @param pageName имя jsp-страницы
	 * @return путь к jsp-странице
	 */
	public static String getPagePath(String pageName) {
		return PREFIX_PATH + bundle.getString(pageName) + EXTENSION;
	}
	
	/**
	 * Метод для получения url-адреса по ключу
	 * 
	 * @param urlName ключ
	 * @return url-адрес страницы
	 */
	public static String getUrlPath(String urlName) {
		return bundle.getString(urlName);
	}
	
	/**
	 * Метод для получения url-адреса по ключу с добавленными параметрами
	 * 
	 * @param urlName ключ
	 * @param urlParameters url-параметры в формате "param1=value1&param2=value2" 
	 * @return url-адрес страницы 
	 */
	public static String getUrlPath(String urlName, String urlParameters) {
		if (urlParameters == null) {
			return bundle.getString(urlName);
		} 
		return bundle.getString(urlName) + DELIMITER + urlParameters;
	}
}
