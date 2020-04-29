package kbs.mvc.model.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kbs.mvc.model.domain.QnA;
import kbs.mvc.model.service.QnAService;

public class ReplyFormController implements Controller {

	@Override
	public ModelAndView handleReguest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("ReplyFormController Call");
		
		String qaNo = request.getParameter("qaNo");
		System.out.println(qaNo);	
		
		QnA qna = QnAService.selectByNo(Integer.parseInt(qaNo), false);
		
		request.setAttribute("elec", qna); //update.jsp에서 사용
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("QnAView/reply.jsp");
		
		return mv;
		
	}

}
