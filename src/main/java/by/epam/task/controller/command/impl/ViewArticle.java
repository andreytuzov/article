package by.epam.task.controller.command.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.epam.task.controller.command.ICommand;
import by.epam.task.controller.manager.PageResourceManager;
import by.epam.task.domain.Article;
import by.epam.task.service.ArticleService;
import by.epam.task.service.exception.ServiceException;
import by.epam.task.service.factory.ServiceFactory;

public class ViewArticle implements ICommand {

	private static final Logger logger = Logger.getLogger(ViewArticle.class);
	
	@Override
	public String execute(HttpServletRequest request) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ArticleService articleService = serviceFactory.getArticleService();
		
		int id = Integer.valueOf(request.getParameter("id"));
		Article article = null;
		try {
			article = articleService.findOne(id);
			request.setAttribute("article", article);
		} catch (ServiceException e) {
			logger.error("error competining viewArticle", e);
		} 
		return PageResourceManager.getPagePath("view-article");
	}

}
