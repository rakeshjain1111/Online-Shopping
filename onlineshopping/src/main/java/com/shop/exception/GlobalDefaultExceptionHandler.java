package com.shop.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandler() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","This Page is not Constructed");
		mv.addObject("errorDescription","The Page you are looking for is not available now");
		mv.addObject("title","404 Error Page");
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundHandler() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle","Product is not available");
		mv.addObject("errorDescription","The Product you are looking for is not available Right now");
		mv.addObject("title","Product Unavailable");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		ModelAndView mv = new ModelAndView("error");
		
//		Only For Debugging Purpose
		
		StringWriter sw =new StringWriter();
		PrintWriter pw =new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		mv.addObject("errorTitle","Contact Our Administrator");
		mv.addObject("errorDescription",sw.toString());
		mv.addObject("title","Error");
		return mv;
	}
}
