package kbs.mvc.model.domain;

public class BookDetail {
	
	private Book ISBN;
	private int evaluation;
	private int totalSales;
	private int stock;
	private int discount;
	
	public BookDetail() {}

	public BookDetail(Book iSBN, int evaluation, int totalSales, int stock, int discount) {
		super();
		ISBN = iSBN;
		this.evaluation = evaluation;
		this.totalSales = totalSales;
		this.stock = stock;
		this.discount = discount;
	}
	
	public Book getISBN() {
		return ISBN;
	}
	
	public void setISBN(Book iSBN) {
		ISBN = iSBN;
	}
	
	public int getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	
	
	

}
