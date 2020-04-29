package kbs.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kbs.mvc.model.domain.Orders;

public interface OrdersDAO {

	
	/**
	 * 전체검색 
	 */	
	List<Orders> selectAll() throws SQLException;
	
	/**
	 * 주문번호로 검색 
	 */
	Orders selectByOrderNo(int orderNo)throws SQLException; 
	
	/**
	 * 고객 id로 검색 
	 */
	List<Orders> selectByCustomerId(String id)throws SQLException;
	
	
	void insert(Orders orders)throws SQLException;
	
	//Orders테이블에 주문기본추가
	void insertOrders(Orders orders)throws SQLException;
	
	
	//OrderDetail 테이블에 주문상세 추가 
	void insertOrderDetail(Orders orders)throws SQLException;
	
}
