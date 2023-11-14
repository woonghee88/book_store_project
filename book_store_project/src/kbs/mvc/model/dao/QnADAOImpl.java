package kbs.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kbs.mvc.model.domain.QnA;
import kbs.mvc.util.DBUtil;

public class QnADAOImpl implements QnADAO {
	
	public List<QnA> selectAll() throws SQLException{
		
		String sql = "select * from QnA";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<QnA> list = new ArrayList<QnA>();
				
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			QnA qna = new QnA(rs.getInt("qa_No"), rs.getDate("reg_Dt"), 
					rs.getString("qa_Content"), rs.getString("customer_Id"),
					rs.getInt("read_Num"), rs.getString("title"), rs.getString("password"),
					rs.getString("fname"),rs.getInt("fsize"),rs.getString("reply"));
			
			list.add(qna);
			}			
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return list;
		
	}
	
	
	public QnA selectByNo(int qaNo) throws SQLException{
		
		
		String sql = "select * from QnA where qa_no =?";
		System.out.println("연결");
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		QnA qna =null;
		System.out.println("selectbyNODAO 들어옴 ");
				
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qaNo);
			rs = ps.executeQuery();
			System.out.println("try들어옴");
			if(rs.next()) {
			qna = new QnA(rs.getInt("qa_No"), rs.getDate("reg_Dt"), 
					rs.getString("qa_Content"), rs.getString("customer_Id"),
					rs.getInt("read_Num"), rs.getString("title"), rs.getString("password"),
					rs.getString("fname"),rs.getInt("fsize"),rs.getString("reply"));
				
			}		
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
			System.out.println("out");
		return qna;
		
	}
	

		
	public QnA selectById(String id) throws SQLException{
		
		
		String sql = "select * from QnA where customer_id=?"; 
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		QnA qna =null;
		
				
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
			qna = new QnA(rs.getInt("qa_No"), rs.getDate("reg_Dt"), 
					rs.getString("qa_Content"), rs.getString("customer_Id"),
					rs.getInt("read_Num"), rs.getString("title"), rs.getString("password"),
					rs.getString("fname"),rs.getInt("fsize"),rs.getString("reply"));
				
			}		
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return qna;
	}
	
	public List<QnA> selectBytitle(String title) throws SQLException{
		
		String sql = "select * from QnA where title like ?";
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		QnA qna =null;
		List<QnA> list = new ArrayList<QnA>();
				
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1,"%"+title+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
			qna = new QnA(rs.getInt("qa_No"), rs.getDate("reg_Dt"), 
					rs.getString("qa_Content"), rs.getString("customer_Id"),
					rs.getInt("read_Num"), rs.getString("title"), rs.getString("password"),
					rs.getString("fname"),rs.getInt("fsize"), rs.getString("reply"));
				
			list.add(qna);	
			}	
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return list;
		
	}
	
	/*
	 * 확인완료
	 */
	public int increamentByReadnum(int qaNo) throws SQLException{
		
		String sql = "update QnA set read_Num = read_Num + 1 where qa_No=?";
		System.out.println("잡고있니");
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int result;
				
				
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, qaNo);
			result = ps.executeUpdate();
			
			System.out.println("try22222");	
					
		}finally {
			DBUtil.dbClose(con, ps);
		}
		
		return result;
		
	}
	
	
	public int update(QnA qna) throws SQLException{
		
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="update QnA set title=?, reg_dt=sysdate, QA_content=? where qa_No=?";
		System.out.println("update DAO 들어옴");
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		
		ps.setString(1, qna.getTitle());
		ps.setString(2, qna.getQaContent());
		ps.setInt(3, qna.getQaNo());
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}		
		return result;
	}
	
	public int replyupdate(QnA qna) throws SQLException{
		
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="update QnA set reply=? where qa_No=?";
		System.out.println("replyupdate DAO 들어옴");
		System.out.println(qna.getReply());
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		
		ps.setString(1, qna.getReply());
		ps.setInt(2, qna.getQaNo());
		
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}		
		return result;
	}
	
	
	
	
	
	public int delete(int qaNo , String password) throws SQLException{
		
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="delete from QnA where qa_No=? and password=?";
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, qaNo);
		ps.setString(2, password);
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}		
		return result;
	}
	
	
	public int insert(QnA qna) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		System.out.println("insertDAO 들어옴");
		String sql ="insert into QnA values ( qa_no_seq.NEXTVAL, sysdate, ?, ?, 0, ?, null, ?, ?, ?)";
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
	
		ps.setString(1,qna.getQaContent());
		ps.setString(2, "id1");
		ps.setString(3, qna.getTitle());
		ps.setString(4, qna.getFname());
		ps.setInt(5, qna.getFsize());
		ps.setString(6, qna.getPassword());
		
	
		
		result = ps.executeUpdate();
		System.out.println("insertDAO out");
		}finally {
			DBUtil.dbClose(con, ps);
		}		
		return result;
	}
	
}
