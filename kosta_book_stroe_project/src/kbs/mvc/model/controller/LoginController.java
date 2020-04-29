package kbs.mvc.model.controller;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kbs.mvc.model.domain.Customer;
import kbs.mvc.model.service.CustomerService;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleReguest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("LoginController 호출됨");
		
		String id =request.getParameter("id");
		String password = request.getParameter("password");
		System.out.println(id);
		System.out.println(password);
		
		Customer customer = CustomerService.selectById(id);
		ModelAndView mv = new ModelAndView();
		
		
		if(customer.getId().equals(id) && customer.getPwd().equals(password)) {
			
				
				System.out.println("LoginController if쪽 ");
				HttpSession session = request.getSession();
				
				session.setAttribute("sessionCustomer", customer);
				
				
				Customer cus = (Customer) session.getAttribute("sessionCustomer");
				
				System.out.println("levels="+ cus.getLevels() + cus.getAddr());
				
				
				
				session.setAttribute("sessionTime", new Date().toLocaleString());
				
				//이동하기
				
				//수정
				mv.setRedirect(true);
				mv.setViewName("index.html");
				
				
				//response.sendRedirect("index.html");
							
		}
		return mv;	
	}
}

