package kbs.mvc.model.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kbs.mvc.model.domain.Book;
import kbs.mvc.model.domain.BookDetail;
import kbs.mvc.model.domain.Category;
import kbs.mvc.util.DBUtil;



public class BookDAOImpl implements BookDAO {
	Properties pro = new Properties();

	public BookDAOImpl() {
		//SQL파일로딩 부분
		InputStream input = getClass().getClassLoader().getResourceAsStream("kosta/mvc/model/dao/sqlQuery.properties");

		try {
			pro.load(input);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Book> selectAll() throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null ;
		List<Book> list = new ArrayList<Book>();
		String sql = pro.getProperty("list");
		//String sql = "select * from book";
		try {

			con = DBUtil.getConnection();
			//con = Myconnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {
				Category ct = new Category();
				ct.setCategoryNo(rs.getString("category_no"));
				BookDetail bd = new BookDetail();

				Book book = new Book(rs.getString("ISBN"),rs.getString("book_name"), rs.getString("book_img")
						,rs.getString("author"), rs.getInt("price"), rs.getString("description"), rs.getString("publisher")
						,rs.getString("publish_dt"), ct, bd);

				list.add(book);

			}

		}finally {
			DBUtil.dbclose(con, ps, rs);
			
		}

		return list;
	}

	@Override
	public Book selectByISBN(String ISBN) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		String sql = pro.getProperty("selectByISBN");

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, ISBN.trim());
			rs = ps.executeQuery();

			if(rs.next()) {
				Category ct = new Category();

				BookDetail bd = new BookDetail();

				ct.setCategoryNo(rs.getString("category_no"));
				book = new Book(rs.getString("ISBN"),rs.getString("book_name"), rs.getString("book_img")
						,rs.getString("author"), rs.getInt("price"), rs.getString("description"), rs.getString("publisher")
						,rs.getString("publish_dt"), ct, bd);
			}

		}finally {
			DBUtil.dbclose(con, ps, rs);
		}

		return book;
	}

	@Override
	public List<Book> selectByBookName(String bookName) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Book book = null;
		List<Book> list = new ArrayList<Book>();
		//String sql ="select * from book where book_name like ?";
		String sql = pro.getProperty("selectByBookName");
		try {
			con = DBUtil.getConnection();

			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+bookName+"%");
			rs = ps.executeQuery();

			while(rs.next()) {
				Category ct = new Category();
				BookDetail bd = new BookDetail();

				ct.setCategoryNo(rs.getString("category_no"));
				book = new Book(rs.getString("ISBN"),rs.getString("book_name"), rs.getString("book_img")
						,rs.getString("author"), rs.getInt("price"), rs.getString("description"), rs.getString("publisher")
						,rs.getString("publish_dt"), ct, bd);

				list.add(book);

			}

		}finally {
			
			DBUtil.dbclose(con, ps, rs);
			
		}

		return list;
	}

	@Override
	public int increamentByReadnum(String ISBN) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result=0;

		String sql=pro.getProperty("readnumUpdate");

		try {

			con = DBUtil.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, ISBN);

			result = ps.executeUpdate();

		}finally {
			
			DBUtil.dbClose(con, ps);
			
		}


		return result;
	}

	@Override
	public int insert(Book book) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("insert");
		
		try {
			
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement(sql);

			ps.setString(1, book.getISBN());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getBookImg());
			ps.setString(4, book.getAuthor());
			ps.setInt(5, book.getPrice());
			ps.setString(6, book.getDescription());
			ps.setString(7, book.getPublisher());
			ps.setString(8, book.getPublishDt());
			ps.setString(8, book.getCategoryNo().getCategoryNo());

			result = ps.executeUpdate();

		}finally {
			
			DBUtil.dbClose(con, ps);
			
		}

		return result;
	}

	@Override
	public int delete( String ISBN ) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = pro.getProperty("delete");
		
		try {
			
			con = DBUtil.getConnection();
			
			ps = con.prepareStatement(sql);
			ps.setString(1, ISBN.trim());
			//ps.setString(2, password.trim());

			result = ps.executeUpdate();
		}finally {
			
			DBUtil.dbClose(con, ps);
		
		}

		return result;
	}

	@Override
	public int update(Book book) throws Exception {
		Connection con = DBUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		String sql=pro.getProperty("update");
		
		try{
			ps = con.prepareStatement(sql);

			ps.setString(1, book.getISBN());
			ps.setString(2, book.getBookName());
			ps.setString(3, book.getBookImg());
			ps.setString(4, book.getAuthor());
			ps.setInt(5, book.getPrice());
			ps.setString(6, book.getDescription());
			ps.setString(7, book.getPublisher());
			ps.setString(8, book.getPublishDt());
			ps.setString(9, book.getCategoryNo().getCategoryNo());

			result = ps.executeUpdate();

		}finally{

			DBUtil.dbClose(con, ps);
			
		}
		return result;
	}
}


