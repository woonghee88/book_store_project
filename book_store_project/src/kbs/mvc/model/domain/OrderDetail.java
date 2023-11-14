package kbs.mvc.model.domain;

public class OrderDetail {
	private String orderDetailId;
	private int orderProductQuantity;
	private int orderProductPrice;
	private Orders orderNo;
	private Book book;
	
	public OrderDetail() {}

	public OrderDetail(String orderDetailId, int orderProductQuantity, int orderProductPrice, Orders orderNo,
			Book book) {
		super();
		this.orderDetailId = orderDetailId;
		this.orderProductQuantity = orderProductQuantity;
		this.orderProductPrice = orderProductPrice;
		this.orderNo = orderNo;
		this.book = book;
	}

	public String getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public int getOrderProductQuantity() {
		return orderProductQuantity;
	}

	public void setOrderProductQuantity(int orderProductQuantity) {
		this.orderProductQuantity = orderProductQuantity;
	}

	public int getOrderProductPrice() {
		return orderProductPrice;
	}

	public void setOrderProductPrice(int orderProductPrice) {
		this.orderProductPrice = orderProductPrice;
	}

	public Orders getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Orders orderNo) {
		this.orderNo = orderNo;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book iSBN) {
		this.book = book;
	}

	


}
