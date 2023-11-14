package kbs.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kbs.mvc.model.domain.Customer;
import kbs.mvc.model.domain.Levels;


public interface CustomerDAO {

	/** 
	 * 로그인
	 * @throws Exception 
	 */
	Customer login(String id, String pwd)throws SQLException;
	
	
	/** 
	 * 가입
	 */
	int insert(Customer c)throws SQLException;
	
	
	/**
	 * 아이디 중복체크 
	 */
	boolean idCheck(String id)throws SQLException;
	/**
	 * 수정하기 
	 */
	void update(Customer c)throws SQLException;
	
	/**
	 * 탈퇴
	 */
	int deleteCustomer(String id)throws SQLException;
	
	/**
	 * keyField 에 해당하는(필드명) keyword를 포한한 레코드 검색하기 
	 * ex)
	 * select * from member where id like '%a%' or
	 * select * from member where name like '%a%' or
	 * select * from member where addr like '%a%' 
	 */
	List<Customer> searchByKeyword(String keyField, String keyWord)throws SQLException;
	
	
	/**
	 * 회원 전체 검색 
	 */
	List<Customer> selectAll()throws SQLException;
	
	
	/**
	 * 아이디로 회원 검색 
	 */
	Customer selectById(String id) throws SQLException;
	
	
	/**
	 * 이메일로 회원 검색 
	 */
	Customer selectByEmail(String email)throws SQLException;
	
	/**
	 * 회원등급으로 검색 
	 */
	List<Customer> selectByLevels(Levels levels) throws SQLException;
	
}