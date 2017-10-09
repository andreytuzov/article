package by.epam.task.controller.command.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Article;
import by.epam.task.service.ArticleService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class GetArticleList implements ICommand {

	private static final Logger logger = Logger.getLogger(GetArticleList.class);
	
	@Override
	public String execute(HttpServletRequest request) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ArticleService articleService = serviceFactory.getArticleService();
		try {
			List<Article> listArticle = articleService.findAll();
			request.setAttribute("articles", listArticle);
		} catch (ServiceException e) {
			logger.error("error completing getArticleList ", e);
		}
		return PageResourceManager.getPagePath("page.name.list");
	}

}
