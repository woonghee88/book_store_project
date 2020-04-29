package kbs.mvc.model.controller;
/**
 * ��û�� ����� ���� ������������ 
 * ��� view�̸��� �̵���Ŀ� ���� ���� 
 * @author �ѿ���
 *
 */
public class ModelAndView {
	private boolean isRedirect; //�̵����(true�̸� redirect, false�̸� forward)
	private String viewName; // ��� ���̸�
	
	
	public ModelAndView() {}
	
	
	public ModelAndView(boolean isRedirect, String viewName) {
	
		this.isRedirect = isRedirect;
		this.viewName = viewName;
	}


	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	
}
