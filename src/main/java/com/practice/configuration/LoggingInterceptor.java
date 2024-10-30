package com.practice.configuration;

import java.util.Enumeration;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LoggingInterceptor implements HandlerInterceptor{
	
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("LoggingInterceptor::preHandle()");
    	log.info("LoggingInterceptor::Request: " + request.getMethod() + " " + request.getRequestURI());

    	
    	Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            log.info("LoggingInterceptor::Header: " + request.getHeader(header));
        }
        
        return true;
    }

    @Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
    	log.info("LoggingInterceptor::postHandle()");
	}
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.info("LoggingInterceptor::afterCompletion()");
    	log.info("LoggingInterceptor::Response Status: " + response.getStatus());
    }
    

}
