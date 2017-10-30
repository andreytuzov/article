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

/**
 * Фильтр, обеспечивающий поддержку интернационализации для javascript
 */
public class LanguageScriptFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	/**
	 * Передается массив строк для текущей локали 
	 */
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
