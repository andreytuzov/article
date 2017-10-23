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

import by.epam.task.controller.manager.PageResourceManager;

public class AccessConstraintFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		Object isAdmin = req.getSession().getAttribute("admin"); 
		if (isAdmin != null && (boolean) isAdmin) {
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect(PageResourceManager.getUrlPath("page.url.car.listview"));
		}
	}
	
	@Override
	public void destroy() {
	}
}
