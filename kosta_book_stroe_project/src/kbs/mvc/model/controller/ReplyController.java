package kbs.mvc.model.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kbs.mvc.model.domain.QnA;
import kbs.mvc.model.service.QnAService;

public class ReplyController implements Controller {

	@Override
	public ModelAndView handleReguest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String qaNo = request.getParameter("qaNo");
		String title = request.getParameter("title");
		String password = request.getParameter("password");
		String qaContent = request.getParameter("qaContent");
		
		
		String reply = request.getParameter("reply");
		
		System.out.println(reply);
		
		
		
		System.out.println("답변 Controller qaNo="+qaNo);
		
		QnA qna = new QnA( Integer.parseInt(qaNo), title, qaContent , password);
		qna.setReply(reply);
		System.out.println(qna.getQaNo());
		System.out.println("답변 업데이트 바로 앞");
		int result = QnAService.replyupdate(qna);
		System.out.println("답변 변경result="+result);
		
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(false);
		mv.setViewName("elec?command=read&flag=1&qaNo="+qaNo);
		
		
		return mv;
		
		
	}

}
