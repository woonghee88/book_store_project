package kbs.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kbs.mvc.model.domain.Review;
import kbs.mvc.util.DBUtil;	

public class ReviewDAOImpl implements ReviewDAO {
	
	public List<Review> selectAll() throws Exception{
			
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		String sql = "select * from review";
		List<Review> list = new ArrayList<Review>();
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Review review = new Review(rs.getInt("review_No"), rs.getString("isbn"),
						rs.getDate("reg_Dt"), rs.getString("content"), 
						rs.getString("customer_id"), rs.getInt("read_Num"));
				
				list.add(review);
				
			}
			
			
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return list;
		
	}
	
	public Review selectByNo(int reviewNo ) throws Exception{
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		
		String sql = "select * from review where review_no=?";
		Review review=null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1,reviewNo);
			rs = ps.executeQuery();
			
			review = new Review(rs.getInt("review_No"), rs.getString("isbn"), rs.getDate("reg_Dt"), rs.getString("content"), rs.getString("customer_id"), rs.getInt("read_Num"));
				
						
		}finally {
			
			DBUtil.dbclose(con, ps, rs);
		}
		
		return review;
		
	}
	
	public Review selectByIsbn(String isbn) throws Exception{
		
		String sql = "select * from review where ISBN =?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Review review=null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, isbn);
			rs = ps.executeQuery();
			
			review = new Review(rs.getInt("reviewNo"), rs.getString("isbn"), rs.getDate("regDt"), rs.getString("content"), rs.getString("customer_id"), rs.getInt("readNum"));
							
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return review;
		
	}
	
	public Review selectById(String id) throws Exception{
		
		String sql = "select * from review where customer_id =?";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		Review review=null;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
			review = new Review(rs.getInt("review_No"), rs.getString("isbn"), rs.getDate("reg_Dt"), rs.getString("content"), rs.getString("customer_id"), rs.getInt("read_Num"));
				
			}			
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return review;
		
		
	}
	
	public int update( int reviewNo, int evalution, String content ) throws Exception{
			
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="update review set reg_dt=sysdate, evaluation=?, content=? where review_no=?";
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		
		ps.setInt(1, evalution );
		ps.setString(2, content);
		ps.setInt(3, reviewNo);
		result = ps.executeUpdate();
		
			
		}finally {
			DBUtil.dbClose(con, ps);
		}		
		return result;
	}
	
	public int delete(int reviewNo) throws Exception{
		
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="delete from review where review_No=?";
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, reviewNo);
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}		
		return result;
	}
	
	
	public int insert(Review review) throws Exception{
		
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="insert into Review values ( ?,?,?,sysdate,?,?,0)";
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, review.getReviewNo());
		ps.setString(2, review.getIsbn());
		ps.setInt(3, review.getEvaluation());
		
		ps.setString(4,review.getContent());
		ps.setString(5, review.getCustomer_id());
		
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}		
		return result;
	}
	
}
