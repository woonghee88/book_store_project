package kbs.mvc.model.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kbs.mvc.model.domain.QnA;
import kbs.mvc.model.service.QnAService;

public class UpdateController implements Controller {

	@Override
	public ModelAndView handleReguest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String qaNo = request.getParameter("qaNo");
		String title = request.getParameter("title");
		String password = request.getParameter("password");
		String qaContent = request.getParameter("qaContent");
		
		System.out.println("Controller qaNo="+qaNo);
		
		QnA qna = new QnA( Integer.parseInt(qaNo), title, qaContent , password);
		System.out.println(qna.getQaNo());
		System.out.println("업데이트 바로 앞");
		int result = QnAService.update(qna);
		System.out.println("result="+result);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(false);
		mv.setViewName("elec?command=read&flag=1&qaNo="+qaNo);
		
		
		return mv;
	}

}
