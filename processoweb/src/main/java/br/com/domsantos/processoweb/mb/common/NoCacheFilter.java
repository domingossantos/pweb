package br.com.domsantos.processoweb.mb.common;

import java.io.IOException;

import javax.faces.application.ResourceHandler;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(servletNames={"Faces Servlet"})
public class NoCacheFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		
		if(!servletRequest.getRequestURI().startsWith(servletRequest.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) {
			servletResponse.setHeader("Chache-Control", "no-cache, no-store, must-revalidade");
			servletResponse.setHeader("Pragma", "no-cache");
			servletResponse.setDateHeader("Expires", 0);
		}
		
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig filterChain) throws ServletException {
		
	}
}