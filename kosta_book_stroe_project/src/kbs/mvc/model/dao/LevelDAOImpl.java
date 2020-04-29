package kbs.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kbs.mvc.model.domain.Levels;
import kbs.mvc.util.DBUtil;

public class LevelDAOImpl implements LevelDAO {
	
	public List<Levels> selectAll() throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		List<Levels> list = new ArrayList<Levels>();
		
		try {
		
			String sql = "select * from levels";
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Levels levels = new Levels(rs.getInt("levels"), rs.getInt("discount"), rs.getInt("min"), rs.getInt("max"));
				
				list.add(levels);
				
			}
			
			
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return list;
	}
	
	public Levels selectByLevels(int level) throws SQLException{
		
				
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Levels levels=null;
		try {
			String sql ="select * from levels where levels=?";
			con = DBUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, level);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				levels = new Levels(rs.getInt("levels"), rs.getInt("discount"), rs.getInt("min"), rs.getInt("max"));
							
			}
			
			
		}finally {
			DBUtil.dbclose(con, ps, rs);
		}
		
		return levels;
	}
	
	
	public int update(Levels levels) throws SQLException{
			
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="update Levels set discount=?, min=?, max=? where levels=?";
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		
		ps.setInt(1, levels.getDiscount());
		ps.setInt(2, levels.getMin());
		ps.setInt(3, levels.getMax());
		ps.setInt(4, levels.getLevels());
		
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}		
		return result;
	}
	
	public int delete(int levels) throws SQLException{
		
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="delete from levels where levels=?";
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, levels);
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}		
		return result;
	}
	
	
	public int insert(Levels levels) throws SQLException{
		
		Connection con=null;
		PreparedStatement ps=null;
		int result;
		String sql ="insert into Levels values (?,?,?,?)";
		try {
		con = DBUtil.getConnection();
		ps = con.prepareStatement(sql);
		ps.setInt(1, levels.getLevels());
		ps.setInt(2, levels.getDiscount());
		ps.setInt(3, levels.getMin());
		ps.setInt(4, levels.getMax());
		result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(con, ps);
		}		
		return result;
	}
	
	
}
