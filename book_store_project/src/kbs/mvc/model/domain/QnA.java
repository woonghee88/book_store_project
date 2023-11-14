package kbs.mvc.model.domain;

import java.sql.Date;

public class QnA {
	private int qaNo;
	private Date regDt;
	private String qaContent;
	private String customerId;
	private int readNum;
	private String title;
	private String reply;
	private String password;
	private String  fname; 
	private int  fsize;
	
	
	public QnA() {	}
	
		
		
	public QnA(int qaNo, String password) {
		
		this.qaNo = qaNo;
		this.password = password;
	}

		
	
	public QnA( String title, String qaContent, String password) {
		
		this.title = title;
		this.qaContent = qaContent;
		this.password = password;
	}
	
	public QnA(int qaNo, String title, String qaContent, String password) {
		
		this.qaNo = qaNo;
		this.title = title;
		this.qaContent = qaContent;
		this.password = password;
	}
	

	//파일 업로드 시
	public QnA( String title, String qaContent, String password, String fname, int fsize) {
		
		this.qaContent = qaContent;
		this.title = title;
		this.password = password;
		this.fname = fname;
		this.fsize = fsize;
	}
	

	public QnA(int qaNo, Date regDt, String qaContent, String customerId, int readNum, String title, 
			String password, String fname, int fsize, String reply) {
		
		this.qaNo = qaNo;
		this.regDt = regDt;
		this.qaContent = qaContent;
		this.customerId = customerId;
		this.readNum = readNum;
		this.title = title;
		this.password = password;
		this.fname = fname;
		this.fsize = fsize;
		this.reply = reply;
	}






	public int getQaNo() {
		return qaNo;
	}





	public void setQaNo(int qaNo) {
		this.qaNo = qaNo;
	}



	public String getFname() {
		return fname;
	}



	public void setFname(String fname) {
		this.fname = fname;
	}



	public int getFsize() {
		return fsize;
	}



	public void setFsize(int fsize) {
		this.fsize = fsize;
	}



	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getRegDt() {
		return regDt;
	}



	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}



	public String getQaContent() {
		return qaContent;
	}



	public void setQaContent(String qaContent) {
		this.qaContent = qaContent;
	}



	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public int getReadNum() {
		return readNum;
	}



	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getReply() {
		return reply;
	}



	public void setReply(String reply) {
		this.reply = reply;
	}
	
	
	
}
