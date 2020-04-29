package kbs.mvc.model.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import kbs.mvc.model.domain.Book;
import kbs.mvc.model.domain.OrderDetail;
import kbs.mvc.model.domain.Orders;
import kbs.mvc.util.DBUtil;

public class OrderDetailDAOImpl implements OrderDetailDAO {


	Properties pro= new Properties();

	public OrderDetailDAOImpl() {
		//sqlQuery.properties 파일을 로딩하기 
		InputStream input=getClass().getClassLoader().getResourceAsStream("kosta/mvc/model/dao/sqlQuery.properties");
		try {
			pro.load(input);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<OrderDetail> selectAll() throws SQLException {
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs= null;
		List<OrderDetail> list= new ArrayList<OrderDetail>();
		String sql= "select * from order_Detail ";

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();
			while (rs.next()) {

				Orders or=new Orders();
				or.setOrderNo(rs.getInt("OrderNo"));

				Book b=new Book();
				b.setISBN(rs.getString("ISBN"));

				OrderDetail orderDetail= new OrderDetail(rs.getString("orderDetailId"),rs.getInt("orderProductQuantity"),
						rs.getInt("orderProductPrice"),or,b);
				list.add(orderDetail);
			}

		}finally {
			DBUtil.dbclose(con, ps, rs);
		}

		return list;
	}


	@Override
	public List<OrderDetail> selectById(String orderDetailId) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		List<OrderDetail> list= new ArrayList<OrderDetail>();
		try {
			con=DBUtil.getConnection();
			String sql=" SELECT * FROM Order_Detail where order_detail_id=?  ";
			ps=con.prepareStatement(sql);


			Orders or=new Orders();
			Book b=new Book();


			ps.setString(1,orderDetailId);
			rs=ps.executeQuery();
			while(rs.next()) {
				
				or.setOrderNo(rs.getInt(2));
				b.setISBN(rs.getString(3));
				int order_Product_Quantity=rs.getInt(4);
				int order_Product_Price=rs.getInt(5);
				

			}

		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<OrderDetail> selectByOrderNo(int orderNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		OrderDetail orderDetail=null;
		List<OrderDetail> list = new ArrayList<OrderDetail>();
		OrderDetail orderDetail = new OrderDetail();
		try {
			con = DBUtil.getConnection();
			String sql = "SELECT  * FROM Order_Detail where order_No=? ";
			ps = con.prepareStatement(sql);
			ps.setInt(1,orderNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				Book b=new Book();
			
				
			orderDetail = new OrderDetail(rs.getString("order_detail_id"),
					rs.getInt("order_no"), , rs.getInt("orderProduct_Quantity"),
					rs.getInt("order_product_price"),b.setISBN(rs.getString("isbn"));
				
			list.add(orderDetail);
				
			
				
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		return list;
	}

	@Override
	public List<OrderDetail> selectByISBN(String ISBN) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		List<OrderDetail> list= new ArrayList<OrderDetail>();
		try {
			con=DBUtil.getConnection();
			String sql=" SELECT * FROM Order_Detail where ISBN=?  ";
			ps=con.prepareStatement(sql);


			Orders or=new Orders();
			//Book book=new Book();


			ps.setString(1,ISBN);
			rs=ps.executeQuery();
			while(rs.next()) {
				String order_detail_id=rs.getString(1);
				or.setOrderNo(rs.getInt(2));
				int orderProduct_Quantity=rs.getInt(4);
				int orderProduct_Price=rs.getInt(5);
				
			}

		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		return list;
	}
}
