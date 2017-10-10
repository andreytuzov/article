package by.epam.task.controller.manager;

import java.util.ResourceBundle;

public class PageResourceManager {
	
	private PageResourceManager() {}
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("page");
	
	public static final String PREFIX_PATH = "/WEB-INF/views/pages/";
	public static final String EXTENSION = ".jsp";
	
	public static String getPagePath(String pageName) {
		return PREFIX_PATH + bundle.getString(pageName) + EXTENSION;
	}
	
}
