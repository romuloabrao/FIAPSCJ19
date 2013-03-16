package br.com.fiap.samf.mbeam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.samf.mbeam.SessionUser;

/**
 * Servlet Filter implementation class FilterLogin
 */
//@WebFilter("*.jsf")
public class FilterLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FilterLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if(!((HttpServletRequest) request).getRequestURL().toString().endsWith("login.jsf")){
			SessionUser su = (SessionUser) ((HttpServletRequest) request).getSession().getAttribute("sessionUser");
			if(su != null && su.isLoggedIn()){
				chain.doFilter(request, response);
			}else{
				((HttpServletResponse) response).sendRedirect("/SAMF/pages/login");
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
