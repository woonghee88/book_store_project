package kbs.mvc.model.domain;

import java.sql.Date;


public class Review {
	private int reviewNo;
	private String isbn;
	private int evaluation;
	private Date regDt;
	private String content;
	private String customer_id;
	private int readNum;
	
		
	public Review() {}
	
	
	
	public Review(int reviewNo, String isbn, int evaluation, String content, String customer_id) {
		
		this.reviewNo = reviewNo;
		this.isbn = isbn;
		this.evaluation = evaluation;
		this.content = content;
		this.customer_id = customer_id;
	}



	public Review(int reviewNo, String isbn, Date regDt, String content, String customer_id, int readNum) {
		super();
		this.reviewNo = reviewNo;
		this.isbn = isbn;
		this.regDt = regDt;
		this.content = content;
		this.customer_id = customer_id;
		this.readNum = readNum;
		
	}
	
	public Review(int reviewNo, String isbn, int evaluation, Date regDt, String content, String customer_id,
			int readNum) {
		super();
		this.reviewNo = reviewNo;
		this.isbn = isbn;
		this.evaluation = evaluation;
		this.regDt = regDt;
		this.content = content;
		this.customer_id = customer_id;
		this.readNum = readNum;
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public Date getRegDt() {
		return regDt;
	}
	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public int getReadNum() {
		return readNum;
	}
	public void setReadNum(int readNum) {
		this.readNum = readNum;
	}
	
}
