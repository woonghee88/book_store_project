package kbs.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kbs.mvc.model.domain.Delivery;
import kbs.mvc.util.DBUtil;

public class DeliveryDAOImpl implements DeliveryDAO {

	
	
	public List<Delivery> selectAll() throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Delivery> list = new ArrayList<Delivery>();
		
		String sql= "select * from delivery";
		
		
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			
			
			Delivery delivery = new Delivery(rs.getInt("order_no"), rs.getString("customer_id"), 
					rs.getInt("delivery_Status"),
					rs.getString("address"));
			
			
			list.add(delivery);
			
		}
		
		}finally{
			DBUtil.dbclose(con, ps, rs);
		}
		
		
		return list; 
		
	}
	
	
	public Delivery selectByNo(int orderNo) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Delivery delivery = null;
		String sql= "select * from delivery where order_no =?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, orderNo);
			rs = ps.executeQuery();
			
			if(rs.next()) {
					
				 delivery = new Delivery(rs.getInt("order_no"), rs.getString("customer_Id"), rs.getInt("delivery_Status"),
						rs.getString("address"));
								
			}
			
			}finally{
				DBUtil.dbclose(con, ps, rs);
			}
			
			
			return delivery; 
			
		}
		
	public List<Delivery> selectById(String id) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Delivery delivery = null;
		List<Delivery> list = new ArrayList<Delivery>();
		String sql= "select * from delivery where id =?";
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
					
				 delivery = new Delivery(rs.getInt("order_no"), rs.getString("customer_Id"), rs.getInt("delivery_Status"),
						rs.getString("address"));
				
				list.add(delivery); 
			}
			
			}finally{
				DBUtil.dbclose(con, ps, rs);
			}
			
			
			return list; 
			
		}
			
}
