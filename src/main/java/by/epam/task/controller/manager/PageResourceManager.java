package by.epam.task.controller.manager;

import java.util.ResourceBundle;

public class PageResourceManager {
	
	private PageResourceManager() {}
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("page");
	
	public static final String PREFIX_PATH = "/WEB-INF/views/pages/";
	public static final String EXTENSION = ".jsp";
	public static final String DELIMITER = "&";
	
	public static String getPagePath(String pageName) {
		return PREFIX_PATH + bundle.getString(pageName) + EXTENSION;
	}
	
	public static String getUrlPath(String urlName) {
		return bundle.getString(urlName);
	}
	
	public static String getUrlPath(String urlName, String urlParameters) {
		if (urlParameters == null) {
			return bundle.getString(urlName);
		} 
		return bundle.getString(urlName) + DELIMITER + urlParameters;
	}
	
	
}
