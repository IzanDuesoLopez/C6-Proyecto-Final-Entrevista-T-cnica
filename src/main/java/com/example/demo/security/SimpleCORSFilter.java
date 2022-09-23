package com.example.demo.security;

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
import org.springframework.stereotype.Component;

@Component
public class SimpleCORSFilter implements Filter {

	// Logger
	private final Logger log = LoggerFactory.getLogger(SimpleCORSFilter.class);

	// Log info
	public SimpleCORSFilter() {
		log.info("SimpleCORSFilter init");
	}

	/**
	 * We filter the Acces-Control allowing the following origins, credentials, methods, max-age and headers.
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers",
				"Content-Type, Accept, X-Requested-With, remember-me, Host, Content-Lenght");
		
		System.out.println("ACCESSSSSSSSSSSSSSS REQUEST = " + request.getHeader("Access-Control-Allow-Origin"));
		System.out.println("ACCESSSSSSSSSSSSSSS RESPONSE = " + response.getHeader("Access-Control-Allow-Origin"));

		chain.doFilter(req, res);
	}

	/**
	 * We initialize the config
	 */
	@Override
	public void init(FilterConfig filterConfig) {
	}

	/**
	 * Method to destroy the instance
	 */
	@Override
	public void destroy() {
	}

}
