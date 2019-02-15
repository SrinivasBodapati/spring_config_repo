package com.boa.kyc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionAnonymousFilter implements Filter {
	
	private static final Logger LOGGER  = LoggerFactory.getLogger(TransactionAnonymousFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		LOGGER.info("Ananymous filter remote Host .." + request.getRemoteHost());
		
		chain.doFilter(httpRequest, httpResponse);
		
	}
	
	public void destory( ) {
		Filter.super.destroy();
		System.out.println("Ananymous filter destroy method..");
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		LOGGER.info("Ananymous filter init method");
	}

}
