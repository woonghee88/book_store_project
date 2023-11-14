package kbs.mvc.model.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kbs.mvc.model.domain.QnA;
import kbs.mvc.model.service.QnAService;

public class ReadController implements Controller {

	@Override
	public ModelAndView handleReguest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("ReadElecController Call");
		
				
		String qaNo = request.getParameter("qaNo");
		System.out.println("qaNo=" + qaNo);
		String flag = request.getParameter("flag");
		
		boolean state = flag==null? true : false;
//		if(qaNo==null || qaNo.equals("")) {
//			throw new RuntimeException("�𵨹�ȣ �Է°��� ������� �ʽ��ϴ�.");
//		}else {
			
			System.out.println("서비스보내기 바로전");
			QnA qna = QnAService.selectByNo(Integer.parseInt(qaNo), state);
			System.out.println(qna);
			request.setAttribute("elec", qna);
			ModelAndView mv = new ModelAndView(false, "QnAView/qnaDetail.jsp");
			return mv; 
			
			
			
//		}
		
			
		
	}

}
