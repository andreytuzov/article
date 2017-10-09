package by.epam.task.controller.manager;

import java.util.ResourceBundle;

public class PageResourceManager {
	
	private PageResourceManager() {}
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("page");
	
	public static String getPagePath(String pageName) {
		return "/WEB-INF/views/pages/" + bundle.getString(pageName) + ".jsp";
	}
	
}
