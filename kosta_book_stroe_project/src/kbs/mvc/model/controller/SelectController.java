package kbs.mvc.model.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kbs.mvc.model.domain.QnA;
import kbs.mvc.model.domain.Review;
import kbs.mvc.model.service.QnAService;

public class SelectController implements Controller {

	@Override
	public ModelAndView handleReguest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		System.out.println("SelectController Call");
		
		List<QnA> list = QnAService.selectAll();
		//System.out.println(list);
			
		
		
		request.setAttribute("list", list);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("QnAView/qnaList.jsp");
		System.out.println("SelectController Out");
		return mv;
		
	}
	
	

}
