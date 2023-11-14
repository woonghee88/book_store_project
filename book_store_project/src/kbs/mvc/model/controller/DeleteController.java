package kbs.mvc.model.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kbs.mvc.model.service.QnAService;

public class DeleteController implements Controller {

	@Override
	public ModelAndView handleReguest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//�˻����
		System.out.println("DeleteElecController Call");
		
		String qaNo = request.getParameter("qaNo");
		String password = request.getParameter("password");
		String path = request.getServletContext().getRealPath("/save");
		
		QnAService.delete(Integer.parseInt(qaNo), password, path);
		
		ModelAndView mv = new ModelAndView();
		mv.setRedirect(true);//redirect���
		mv.setViewName("elec");
		
		return mv;
		
		
	}

}
