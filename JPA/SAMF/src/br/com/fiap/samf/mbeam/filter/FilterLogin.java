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

@WebFilter("*.jsf")
public class FilterLogin implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {    
    	if(!((HttpServletRequest) request).getRequestURL().toString().endsWith("login.jsf")){
	    	HttpServletRequest req = (HttpServletRequest) request;
	        SessionUser auth = (SessionUser) req.getSession().getAttribute("sessionUser");
	        HttpServletResponse res = (HttpServletResponse) response;
	        if (auth == null) {
	            res.sendRedirect("/SAMF/pages/login.jsf");
	        }else if(!auth.isLoggedIn()){
	            res.sendRedirect("/SAMF/pages/login.jsf");
	        }
    	}
    	chain.doFilter(request, response);
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}// You need to override init() and destroy() as well, but they can be kept empty.
