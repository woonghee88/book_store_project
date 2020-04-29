package kbs.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import kbs.mvc.model.domain.Customer;
import kbs.mvc.model.domain.Levels;
import kbs.mvc.util.DBUtil;




	public class CustomerDAOImpl implements CustomerDAO {


		Properties pro= new Properties();

//		public CustomerDAOImpl() {
//			//sqlQuery.properties 파일을 로딩하기 
//			InputStream input=getClass().getClassLoader().getResourceAsStream("kosta/mvc/model/dao/sqlQuery.properties");
//			try {
//				pro.load(input);
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		
		@Override
		public Customer login(String id, String pwd) throws SQLException {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Customer customer = new Customer();
			try {
				con = DBUtil.getConnection();
				//2)SQL송신
				String sql =  "SELECT * FROM customer WHERE id=? AND pwd = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pwd);
				rs = ps.executeQuery();
				if(rs.next()) {
					
					
					String name = rs.getString("name");
					String gender=rs.getString("gender");
					int age=rs.getInt("age");
					String addr=rs.getString("addr");
					String phone =rs.getString("phone");
					String email=rs.getString("email");
					//int status = rs.getInt("customer_state");
					//Levels le=new Levels();
					//le.setLevels(rs.getInt("levels"));
					
						 customer= new Customer(id,pwd,name,gender,age,addr,phone,email);
					
				}else {
					throw new Exception("아이디 또는 비밀번호가 틀렸습니다.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			}finally {
				//3) DB연결해제
				DBUtil.dbclose(con, ps, null);
			}
			return customer;
		}
		
		@Override
		public int insert(Customer c) throws SQLException {
			Connection con=null;
			PreparedStatement ps=null;
			int result=0;
				try {
					con = DBUtil.getConnection();
			String sql=pro.getProperty("customerInsert");
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1, c.getId());
				ps.setString(2, c.getPwd());
				ps.setString(3, c.getName());
				ps.setString(4, c.getGender());
				ps.setInt(5, c.getAge());
				ps.setString(6, c.getAddr());
				ps.setString(7, c.getPhone());
				ps.setString(8, c.getEmail());
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				if(e.getErrorCode()==1)
					throw new Exception("이미 존재하는 아이디 입니다.");
				throw new Exception(e.getMessage());
			}
			} catch (Exception e) {
				e.printStackTrace();
				
			}finally {
				DBUtil.dbclose(con, ps, null);
				}

				return result;
		}
		
		
		
		
		@Override
		public boolean idCheck(String id) throws SQLException {
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			boolean result=false;
			String sql=pro.getProperty("customerUpdate");
			try {
				con = DBUtil.getConnection();
				ps = con.prepareStatement(sql);
				//ps.setString(1, id.trim().toUpperCase());
				ps.setString(1, id);	
				rs = ps.executeQuery();
				if(rs.next())result=true;
			}finally {
				DBUtil.dbclose(con, ps, rs);
			}
			return result;
		}
		
		@Override
		public void update(Customer c) throws SQLException {
			Connection con=null;
			Statement stmt=null;
			try {
				con = DBUtil.getConnection();
				String updateSQL1="UPDATE customer SET ";
				String updateSQL2=" WHERE id='"+c.getId()+"'";
				boolean flag=false;
				if(c.getPwd()!=null) {  //null이아니면 수정한다 
					updateSQL1 +="pwd='" +c.getPwd()+"'";
					flag=true;
				}
				if(c.getName()!=null) {
					if(flag) {
						updateSQL1 += ",";
					}
					updateSQL1 +="name='" +c.getName()+"'";
					flag=true;
				}
				if(c.getCustomerState()!=0) {
					if(flag) {
						updateSQL1 += ",";
					}
					updateSQL1 += "customer_status="+c.getCustomerState();
					flag=true;
				}
				if(c.getAddr()!=null) {
					if(flag) {
						updateSQL1 += ",";
					}
					updateSQL1 += "addr="+c.getAddr();
					flag=true;
				}
				if(c.getAge()!=0) {
					if(flag) {
						updateSQL1 += ",";
					}
					updateSQL1 += "age="+c.getAge();
					flag=true;
				}
				if(c.getPhone()!=null) {
					if(flag) {
						updateSQL1 += ",";
					}
					updateSQL1 += "	phone="+c.getPhone();
					flag=true;
				}
				if(flag) {//flag가 true라면 하나라도 있다면 한개라도 값을 수정해야함
					stmt=con.createStatement();
					stmt.executeUpdate(updateSQL1+updateSQL2);
				}
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
				DBUtil.dbclose(con, stmt, null);
			}
		}
		
		@Override
		public List<Customer> searchByKeyword(String keyField, String keyWord) throws SQLException {
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			List<Customer> list =new ArrayList<Customer>();
			String sql="SELECT ID, PWD, NAME, gender,AGE,addr, PHONE, mileage,reg_dt,email,levels FROM customer ";
			try {
				if(keyField.equals("id"))
					sql+="where id like ? ";

				else if(keyField.equals("email"))
					sql+="where email like ? ";
				else if(keyField.equals("levels"))
					sql+="where levels like ? ";
			

					//로드 실행 연결 닫기  
					con = DBUtil.getConnection();
					ps = con.prepareStatement(sql);
					//?의 개수만큼 setXxx()가 필요하다. 
					//근데여기는 없어서 생략 
					ps.setString(1, "%"+keyWord.trim()+"%");
					rs = ps.executeQuery();

					while(rs.next()) {
						Levels le=new Levels();
						le.setLevels(rs.getInt("levels"));



						Customer customer=new Customer(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
								rs.getString("gender"), rs.getInt("age"),rs.getString("addr"),
								rs.getString("phone"), rs.getInt("mileage"), rs.getDate("reg_Dt"),
								rs.getString("email"), rs.getInt("customer_State"),le);
						//list에 추가
						list.add(customer);
					}
					
				}finally {
					DBUtil.dbclose(con, ps, rs);
				}
				return list;
			}
		
		@Override
		public int deleteCustomer(String id) throws SQLException {
			Connection con=null;
			PreparedStatement ps=null;
			int result=0;
			String sql="DELETE FROM MEMBER WHERE id= ?";
			try {
				con = DBUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1,id);	
				result= ps.executeUpdate();
			}finally {
				DBUtil.dbClose(con, ps);
			}
			return result;
			
		}


		@Override
		public List<Customer> selectAll() throws SQLException {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Customer> list = new ArrayList<Customer>();
			String sql= "select * from customer WHERE customer_state = 1";

			try {
				try {
					con = DBUtil.getConnection();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps = con.prepareStatement(sql);

				rs = ps.executeQuery();
				while (rs.next()) {

					Levels le=new Levels();
					le.setLevels(rs.getInt("levels"));



					Customer customer=new Customer(rs.getString("id"), rs.getString("pwd"), rs.getString("name"),
							rs.getString("gender"), rs.getInt("age"),rs.getString("addr"),
							rs.getString("phone"), rs.getInt("mileage"), rs.getDate("reg_Dt"),
							rs.getString("email"), rs.getInt("customer_State"),le);

					list.add(customer);

				}
			}finally {
				DBUtil.dbclose(con, ps, rs);
			}

			return list;
		}

		@Override
		public Customer selectById(String id) throws SQLException {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Customer customer = new Customer();
			try {
				con = DBUtil.getConnection();
			
				//String sql = pro.getProperty("selectById");
				String sql = "select * from customer where id=?";
				ps = con.prepareStatement(sql);
				ps.setString(1,id);
				rs = ps.executeQuery();
				if(rs.next()) {
					Levels le=new Levels();


					String pwd= rs.getString(2);
					String name= rs.getString(3);
					String gender=rs.getString(4);
					int age=rs.getInt(5);
					String addr=rs.getString(6);
					String phone=rs.getString(7);
					int mileage=rs.getInt(8);
					Date reg_Dt= rs.getDate(9);
					String email= rs.getString(10);
					int customer_state= rs.getInt(11);
					le.setLevels(rs.getInt(12));

					customer = new Customer(id,pwd,name,gender,age, addr,phone,mileage,reg_Dt,email,customer_state,le);
					return customer;
				} else if(rs.next()) {
					throw new Exception(id+"에 대한 정보가 없습니다.");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.dbclose(con, ps, rs);
			}
			return customer;
		}

		@Override
		public Customer selectByEmail(String email) throws SQLException {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			Customer customer = new Customer();
			try {
				con = DBUtil.getConnection();
				String sql = pro.getProperty("selectByEmail");
				ps = con.prepareStatement(sql);
				ps.setString(1,email);
				rs = ps.executeQuery();
				if(rs.next()) {
					String id=rs.getString(1);
					String pwd= rs.getString(2);
					String name= rs.getString(3);
					String gender=rs.getString(4);
					int age=rs.getInt(5);
					String addr=rs.getString(6);
					String phone=rs.getString(7);
					int mileage=rs.getInt(8);
					Date reg_Dt= rs.getDate(9);
					int customer_state= rs.getInt(11);

					Levels le=new Levels();
					le.setLevels(rs.getInt(12));

					customer = new Customer(id,pwd,name,gender,age, addr,phone,mileage,reg_Dt,email,customer_state,le);
					return customer;
				} else if(rs.next()) {
					throw new Exception(email+"에 대한 정보가 없습니다.");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.dbclose(con, ps, rs);
			}
			return customer;
		}


		
		@Override
		public List<Customer> selectByLevels(Levels levels) throws SQLException {
			Connection con=null;
			PreparedStatement ps=null;
			ResultSet rs= null;
			List<Customer> list= new ArrayList<Customer>();
			
			try {
				con = DBUtil.getConnection();
				String sql= pro.getProperty("selectByLevels");
				//" SELECT * FROM CUSTOMER WHERE levels= ? and customer_State = 1";
				ps=con.prepareStatement(sql);
				
				
				Levels lee=new Levels(1,30,0,1000);
				System.out.println(levels.getLevels());
				ps.setInt(1,levels.getLevels());
				
				rs=ps.executeQuery();
				while(rs.next()) {
					String id=rs.getString(1);
					String pwd= rs.getString(2);
					String name= rs.getString(3);
					String gender=rs.getString(4);
					int age=rs.getInt(5);
					String addr=rs.getString(6);
					String phone=rs.getString(7);
					int mileage=rs.getInt(8);
					Date reg_Dt= rs.getDate(9);
					String email=rs.getString(10);
					int customer_State= rs.getInt(11);
					//Levels lee= new Levels();
					
						Customer customer= new Customer(id,pwd,name,gender,age, addr,phone,mileage,reg_Dt,email,customer_State,lee);
						list.add(customer);
						return list;
				}

			}catch(Exception e) {
				e.printStackTrace();

			}finally {
				DBUtil.dbclose(con, ps, rs);
			}
			return list;
		}

}
	


