package kbs.mvc.model.domain;

import java.util.Date;
import java.util.List;

public class Orders {
	private int orderNo;
	private Date orderDt;
	private int totalPrice;
	private int deliveryPrice;
	private Customer customerId;
	private List<OrderDetail> detail;
	private List<Delivery> delivery;
	public Orders() {}

	
	
	public Orders(int orderNo, Date orderDt, int totalPrice, int deliveryPrice, Customer customerId) {
		
		this.orderNo = orderNo;
		this.orderDt = orderDt;
		this.totalPrice = totalPrice;
		this.deliveryPrice = deliveryPrice;
		this.customerId = customerId;
	}
	
		
	public Orders(int orderNo, Date orderDt, int totalPrice, int deliveryPrice, Customer customerId,
			List<OrderDetail> detail, List<Delivery> delivery) {
		super();
		this.orderNo = orderNo;
		this.orderDt = orderDt;
		this.totalPrice = totalPrice;
		this.deliveryPrice = deliveryPrice;
		this.customerId = customerId;
		this.detail = detail;
		this.delivery = delivery;
	}



	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public Date getOrderDt() {
		return orderDt;
	}

	public void setOrderDt(Date orderDt) {
		this.orderDt = orderDt;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(int deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public List<OrderDetail> getDetail() {
		return detail;
	}

	public void setDetail(List<OrderDetail> detail) {
		this.detail = detail;
	}
	
	

	
	
	
}
