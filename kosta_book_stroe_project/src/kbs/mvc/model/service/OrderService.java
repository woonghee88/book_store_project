package kbs.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import kbs.mvc.model.dao.BookDAO;
import kbs.mvc.model.dao.BookDAOImpl;
import kbs.mvc.model.dao.DeliveryDAOImpl;
import kbs.mvc.model.dao.OrderDetailDAOImpl;
import kbs.mvc.model.dao.OrdersDAO;
import kbs.mvc.model.dao.OrdersDAOImpl;
import kbs.mvc.model.domain.Book;
import kbs.mvc.model.domain.Delivery;
import kbs.mvc.model.domain.OrderDetail;
import kbs.mvc.model.domain.Orders;

public class OrderService {
	
	private static OrdersDAO orderDAO = new OrdersDAOImpl();
	private static OrderDetailDAOImpl orderDetailDAO = new OrderDetailDAOImpl();
	private static DeliveryDAOImpl delDAO = new DeliveryDAOImpl();
	private static BookDAO bookDAO = new BookDAOImpl();
	
	
	public static List<Orders> selectAll() throws SQLException{
		System.out.println("전체검색 서비스");
		
		List<Orders> list = orderDAO.selectAll();
		System.out.println(list);
		return list;
	}
	
	
	public static List<Orders> selectByCustomerId(String id) throws SQLException {
		System.out.println("ID별 주문내역 검색 서비스");
		System.out.println(id);
		List<Orders> orderlist = orderDAO.selectByCustomerId(id);
		List<Delivery> delilist = delDAO.selectById(id);
		List<OrderDetail> detaillist = orderDetailDAO.selectById(id);
		//orderDetail orderDetail = new OrderDetail();
		
		for( Orders orders : orderlist) {
			
		OrderDetail orderDetail =orderDetailDAO.selectByOrderNo(orders.getOrderNo()); 
		
		Book book = bookDAO.selectByISBN(orderDetail.getBook().getISBN());
		
		orderDetail.setBook(book);
		
		
		
		Order order = new Order()
		
		}
		
		
		
		
		
		
		//System.out.println(list);
		
		return orderlist;
	}
}
