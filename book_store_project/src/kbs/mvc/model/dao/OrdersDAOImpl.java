package kbs.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import kbs.mvc.model.domain.Book;
import kbs.mvc.model.domain.Customer;
import kbs.mvc.model.domain.OrderDetail;
import kbs.mvc.model.domain.Orders;
import kbs.mvc.util.DBUtil;

public class OrdersDAOImpl implements OrdersDAO {



	Properties pro= new Properties();

	public OrdersDAOImpl() {
		//sqlQuery.properties 파일을 로딩하기 
//		InputStream input=getClass().getClassLoader().getResourceAsStream("kosta/mvc/model/dao/sqlQuery.properties");
//		try {
//			pro.load(input);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	@Override
	public List<Orders> selectAll() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Orders> list = new ArrayList<Orders>();
		String sql= "select * from orders order by order_no ";

		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
				
			rs = ps.executeQuery();
			while (rs.next()) {

				Customer cus=new Customer();
				cus.setId(rs.getString("customer_Id"));

				//OrderDetail detail=new OrderDetail();
				//detail.set

				Orders orders=new Orders(rs.getInt("order_No"), rs.getDate("order_Dt"), rs.getInt("total_Price"),
						rs.getInt("delivery_Price"),cus);

				list.add(orders);

			}
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}

		return list;
	}
	@Override
	public List<Orders> selectByCustomerId(String id) throws SQLException {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		List<Orders> list= new ArrayList<Orders>();
		try {
			con=DBUtil.getConnection();
			String sql="SELECT * FROM orders where customer_id=?";
			ps=con.prepareStatement(sql);
				
				
			Customer cus=new Customer();
			cus.setId(id);
				
			ps.setString(1,id);
			rs=ps.executeQuery();

			while(rs.next()) {
				int order_No=rs.getInt(1);
				Date order_Dt=rs.getDate(2);
				int total_Price= rs.getInt(3);
				int delivery_Price= rs.getInt(4);
				String customerid = rs.getString(5);
			
			Customer customerId= new Customer();
			customerId.setId(customerid);
			Orders orders = new Orders(order_No, order_Dt, total_Price, delivery_Price, customerId);
				
				
			list.add(orders);	
			}

		}catch(Exception e) {
			e.printStackTrace();

		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		return list;
	}


	@Override
	public Orders selectByOrderNo(int orderNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Orders orders = new Orders();
		try {
			con = DBUtil.getConnection();
			String sql = "SELECT *  FROM orders where  order_no=?  ";
			ps = con.prepareStatement(sql);
			ps.setInt(1,orderNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				Date order_Dt=rs.getDate(2);
				int total_Price= rs.getInt(3);
				int delivery_Price= rs.getInt(4);
				Customer cus=new Customer();
				cus.setId(rs.getString(5));



				orders = new Orders(orderNo, order_Dt, total_Price,delivery_Price ,cus );
				return orders;
			} else if(rs.next()) {
				throw new Exception(orderNo+"에 대한 정보가 없습니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		return orders;
	}

	@Override
	public void insert(Orders orders) throws SQLException {
		Connection con= null;
		try {
			con=DBUtil.getConnection();
			con.setAutoCommit(false);
			insertOrders(orders);
			insertOrderDetail(orders);

			con.commit();

		}catch(Exception e) {
			if(con !=null) {


				try {
					con.rollback();
				}catch(SQLException e1) {
					e1.printStackTrace();

				}
			}

		}
	}

	@Override
	public void insertOrders(Orders orders) throws SQLException {
		Connection con=null;
		PreparedStatement ps= null;
		try{

			String insertOrdersSQL =
					"INSERT INTO orders(order_no, order_id) VALUES(?, ?)";

			ps = con.prepareStatement(insertOrdersSQL);
			ps.setInt(1, orders.getOrderNo());
			ps.setString(2, orders.getCustomerId().getId());
			ps.executeUpdate();
			///자료추가 끝
		}catch(Exception e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());

		}
	}

	@Override
	public void insertOrderDetail(Orders orders) throws SQLException {
		Connection con=null;
		PreparedStatement ps= null;
		try{

			String insertOrderLineSQL =
					"INSERT INTO order_detail(order_detail_id, order_no, order_Product_Quantity, order_Product_Price, ISBN) VALUES(?, ?, ?, ?, ?)"; 
			ps = con.prepareStatement(insertOrderLineSQL);
			for(OrderDetail detail: orders.getDetail()) {

				ps.setString(1, detail.getOrderDetailId());
				ps.setInt(2, orders.getOrderNo());
				ps.setInt(3,detail.getOrderProductQuantity());
				ps.setInt(5, detail.getOrderProductPrice());
				Book bo=new Book();
				ps.setString(6, bo.getISBN());

				//pstmt.executeUpdate();//할때마다 이거하는거 퍼포먼스 떨어짐

				ps.addBatch();//일괄처리할 작업에 추가
				///자료추가 끝
			}
			ps.executeBatch();//일괄처리
		}catch(Exception e) {
			e.printStackTrace();
			
		}

	}
}