package kbs.mvc.model.service;

import java.sql.SQLException;

import kbs.mvc.model.dao.CustomerDAO;
import kbs.mvc.model.dao.CustomerDAOImpl;
import kbs.mvc.model.domain.Customer;

public class CustomerService {
	
	
	private static CustomerDAO cusDAO = new CustomerDAOImpl();
	
	public static Customer selectById(String id) throws SQLException{
		
		Customer customer = cusDAO.selectById(id);	
		if(customer==null) throw new SQLException("모델번호에 해당하는 정보를 찾을수 없습니다.");
		
		return customer;
	}
	
	
	
	
	
}
