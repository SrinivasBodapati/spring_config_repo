package com.boa.kyc.filters;

import java.io.IOException;
import java.util.Random;

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
import org.springframework.boot.ExitCodeGenerator;

public class TransactionFilter implements Filter, ExitCodeGenerator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		LOGGER.info("Remote Host .." + request.getRemoteAddr());
		if(request.getRemoteAddr().equals("0:0:0:0:0:0:0:1")) {
			throw new RuntimeException("Exit code " + this.getExitCode());
		}
		chain.doFilter(httpRequest, httpResponse);
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
		LOGGER.info("Init method");
	}
	
	public void destory( ) {
		Filter.super.destroy();
		System.out.println("destroy method..");
	}

	@Override
	public int getExitCode() {
		// TODO Auto-generated method stub
		return new Random().nextInt(10000);
	}

}
