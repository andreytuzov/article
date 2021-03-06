package by.epam.task.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Фильтр для установка кодировки запросов и ответов 
 */
public class EncodingFilter implements Filter {
	
	/** Название кодировки */
	private String encoding;
	
	/**
	 * Сохраняется параметр кодировки, указанный в web.xml
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		String encoding = config.getInitParameter("encoding");
		if (encoding != null) {
			this.encoding = encoding;
		}
	}
	
	/**
	 * Устанавливается кодировка запросов и ответов
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);	
	}
	
	@Override
	public void destroy() {
	}
}
