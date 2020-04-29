package kbs.mvc.model.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kbs.mvc.model.domain.QnA;
import kbs.mvc.model.service.QnAService;;

public class InsertController implements Controller {

	@Override
	public ModelAndView handleReguest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("InsertController call");
		
		String saveDir=request.getServletContext().getRealPath("/save");
		int maxSize=1024*1024*100;
		String encoding="UTF-8";
		
		MultipartRequest m = new MultipartRequest(request, 
				saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		//request 전송되는 데이터 유효성 체크
		
				
		//String qaNo = m.getParameter("qaNo");
		String title =m.getParameter("title");
		String qaContent = m.getParameter("qaContent");
		String password = m.getParameter("password");
		
		//System.out.println(qaNo);
		System.out.println(title);
		System.out.println(qaContent);
		System.out.println(password);
		
			if(title==null || title.equals("") ||
				qaContent==null || qaContent.equals("") ||
				password==null || password.equals("")) {
			
			
			throw new RuntimeException("입력값이 충분하지 않습니다.");
			
		}
						
		
		File file = m.getFile("file");
			
		QnA qna= new QnA();
		if(file != null) {
			String fname = file.getName();
			int fsize = (int)file.length();
			 qna = new QnA(  qaContent, title, password, fname, fsize);
		}else {
			 qna = new QnA(  qaContent, title, password);
}
		//electronics.setPassword(password); 
		System.out.println(qna);
		System.out.println("insertService 앞");
		QnAService.insert(qna);
		System.out.println("insertController end");
	
		ModelAndView mv = new ModelAndView(true, "elec");
		return mv;
	}

}