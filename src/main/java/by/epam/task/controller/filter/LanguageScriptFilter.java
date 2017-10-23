package by.epam.task.controller.filter;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class LanguageScriptFilter implements Filter {

	private static final Logger logger = Logger.getLogger(LanguageScriptFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		ResourceBundle bundle = ResourceBundle.getBundle("l10n.script");
		HttpServletRequest req = (HttpServletRequest) request;
		req.setAttribute("keys", bundle.getKeys());
		req.getRequestDispatcher("/WEB-INF/views/pages/script.jsp").forward(request, response); 
	}

	@Override
	public void destroy() {
	}
	
}
