package kbs.mvc.model.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	ModelAndView handleReguest(HttpServletRequest request, HttpServletResponse response) 
		throws Exception;
}
