package kbs.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kbs.mvc.model.domain.OrderDetail;

public interface OrderDetailDAO {

	/**
	 * 전체검색 
	 */
	List<OrderDetail> selectAll() throws SQLException;
	
	/**
	 * id로 찾기 
	 */
	List<OrderDetail> selectById(String orderDetailId) throws SQLException;
	
	
	/**
	 * orderNo로 찾기 
	 */
	OrderDetail selectByOrderNo(int orderNo)throws SQLException;
	
	
	/**
	 * ISBN으로 찾기 
	 */
	List<OrderDetail> selectByISBN(String ISBN) throws SQLException;
	
}
