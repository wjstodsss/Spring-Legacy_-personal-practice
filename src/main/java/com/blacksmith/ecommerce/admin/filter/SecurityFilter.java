package com.blacksmith.ecommerce.admin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecurityFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	    HttpServletResponse httpResponse = (HttpServletResponse) response;

	    HttpSession session = httpRequest.getSession(false); // 세션이 없으면 null 반환
	    
	    System.out.println(session);
	    // 세션에서 로그인 여부를 확인
	    if (session != null && session.getAttribute("email") != null) {
	        // 로그인된 사용자의 경우 요청을 그대로 전달
	        chain.doFilter(request, response);
	    } else {
	   
	        // 로그인되지 않은 사용자의 경우 로그인 페이지로 리다이렉트
	        httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
	    }
	}
    
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}