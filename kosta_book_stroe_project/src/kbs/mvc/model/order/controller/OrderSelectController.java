package kbs.mvc.model.order.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kbs.mvc.model.controller.Controller;
import kbs.mvc.model.controller.ModelAndView;
import kbs.mvc.model.domain.Orders;
import kbs.mvc.model.service.OrderService;

public class OrderSelectController implements Controller {

	@Override
	public ModelAndView handleReguest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
			
		List<Orders> list = OrderService.selectByCustomerId(id);
		
		request.setAttribute("list", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customerDetail/orderList.jsp");
		
		return mv;
	}

}
