package kbs.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import kbs.mvc.model.domain.Book;



public interface BookDAO {
	/**
	 * 레코드 전체 검색
	 * */
	List<Book> selectAll() throws Exception;

	/**
	 * ISBN에 해당하는 레코드 검색
	 * @param 
	 * @return 
	 * */
	Book selectByISBN(String ISBN) throws Exception;

	/**
	 * 제목으로 찾기
	 */
	List<Book> selectByBookName(String bookName) throws Exception;


	/**
	 * 조회수를 증가하는 기능
	 * update Electronics set readnum = readnum + 1 where model_num=?
	 * */
	int increamentByReadnum(String ISBN) throws Exception;


	/**
	 * 레코드 삽입
	 * @return : 1-삽입성공 , 0 - 삽입실패
	 * */
	int insert(Book book) throws Exception;

	/**
	 * 모델번호에 해당하는 레코드 삭제
	 * @return : 1-삭제성공 , 0 - 삭제실패
	 * */
	int delete(String ISBN) throws Exception;

	/**
	 * 모델번호에 해당하는 레코드 수정(모델이름, 가격, 내용)
	 * @return : 1-수정성공 , 0 - 수정실패
	 * */
	int update(Book book) throws Exception;
}
