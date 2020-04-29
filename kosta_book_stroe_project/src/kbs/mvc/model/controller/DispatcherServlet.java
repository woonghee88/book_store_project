package kbs.mvc.model.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet(urlPatterns = "/book", loadOnStartup = 1)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, Controller> map;
	
	@Override
	public void init() throws ServletException {
		
		ServletContext application = super.getServletContext();
		map = (Map<String,Controller>)application.getAttribute("map");
		//배고파요 웅희님
	}
	
	@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
		
			System.out.println("디스패쳐 옴");
			
			String key = request.getParameter("command");
			
			if(key==null || key.equals("")) {
				key="list";
			}
			
			System.out.println("map is " + map);
			System.out.println("key is " + key);
			Controller controller = map.get(key); // map<key,controller> �����̱� ������ 
			
			try {
				
				System.out.println("request="+request);
				System.out.println("response="+response);
				System.out.println("controller="+controller);
				
				ModelAndView mv = controller.handleReguest(request, response);
				System.out.println("mv ="+ mv );
				if(mv.isRedirect()) {
					response.sendRedirect(mv.getViewName());
				}else {
					request.getRequestDispatcher(mv.getViewName()).forward(request, response);;
				}
			
			
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMsg", e.getMessage());
				request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
				
			}
		}

}
