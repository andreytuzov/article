package by.epam.task.service.factory;

import by.epam.task.service.ArticleService;
import by.epam.task.service.InitializingService;
import by.epam.task.service.impl.ArticleServiceImpl;
import by.epam.task.service.impl.InitializingServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final ArticleService articleService = new ArticleServiceImpl();
	private final InitializingService initializingService = new InitializingServiceImpl();

	public static ServiceFactory getInstance() {
		return instance;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public InitializingService getInitializingService() {
		return initializingService;
	}

}
