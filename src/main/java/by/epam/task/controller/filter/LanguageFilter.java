package by.epam.task.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Фильтр для изменения локали в сессии
 */
public class LanguageFilter implements Filter {

	/** Название локали */
	private String paramName;
	
	/**
	 * Сохраняется значение локали в переменной из web.xml
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		String paramName = config.getInitParameter("paramName");
		if (paramName != null) {
			this.paramName = paramName;
		}
	}
	
	/**
	 * Изменяется значение локали в сессии
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// Set a new language for the session
		String lang = req.getParameter(paramName);
		if (lang != null) {
			req.getSession().setAttribute("language", lang);
		}
		// Redirect to the previous page
		((HttpServletResponse) response).sendRedirect(req.getHeader("referer"));
	}
	
	@Override
	public void destroy() {
	}

}
