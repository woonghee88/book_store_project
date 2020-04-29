package kbs.mvc.model.service;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import kbs.mvc.model.dao.QnADAOImpl;
import kbs.mvc.model.domain.QnA;

public class QnAService {
	private static QnADAOImpl qnaDAO = new QnADAOImpl();
		
	public static List<QnA> selectAll() throws SQLException{
		System.out.println("서비스 왔다.");
		
		List<QnA> list = qnaDAO.selectAll();
		System.out.println(list);
		return list;
	}
	
		
	
	public static QnA selectByModelnum(int qaNo, boolean flag) throws SQLException{
		if(flag) {
			if(qnaDAO.increamentByReadnum(qaNo)==0)
				throw new SQLException("조회수 증가에 오류가 발생했습니다.");
		}
			
		QnA dbqna = qnaDAO.selectByNo(qaNo);	
		if(dbqna==null) throw new SQLException("모델번호에 해당하는 정보를 찾을수 없습니다.");
		
		return dbqna;
	}	
	
	
	// QnA 게시물 삽입
	public static void insert(QnA qna) throws SQLException {
		
		System.out.println(qna);
		System.out.println(qna.getFname());
		System.out.println(qna.getFsize());
		int result = qnaDAO.insert(qna);
		if(result==0) throw new SQLException("등록 되지 않았습니다.");
					
	}
		
	//
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
	   * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	   * */
		public static QnA selectByNo(int qaNo, boolean flag) throws SQLException{
			System.out.println("서비스 들어옴");
			if(flag) {
				if(qnaDAO.increamentByReadnum(qaNo)==0)
					throw new SQLException("조회수 증가에 오류가 발생했습니다.");
			}
			
			QnA dbqna = qnaDAO.selectByNo(qaNo);	
			if(dbqna==null) throw new SQLException("모델번호에 해당하는 정보를 찾을수 없습니다.");
			
			return dbqna;
		}
		 
		
		 
		 //글번호에 해당하는 게시물 검색
		
	 /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	   * */
		
		public static void delete(int qaNo ,String password, String path) throws SQLException {
	
			QnA dbqna = qnaDAO.selectByNo(qaNo);
			
			System.out.println(dbqna);
			System.out.println(dbqna.getQaNo());
			System.out.println(dbqna.getQaContent());
			System.out.println(dbqna.getPassword());
			
			
			if(!dbqna.getPassword().equals(password)){
				
				throw new SQLException("비밀번호가 일치하지 않습니다.");
				
				
			}
			int result = qnaDAO.delete(qaNo, password);
			if(result==0) {
				throw new SQLException("수정 안되었어용요요");
			}
			
			if(dbqna.getFname() != null) {
				new File(path, dbqna.getFname()).delete();
			}
			
		}
			  
	  /**
	   * ElectronicsDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
	   * */
		
			
		public static int update(QnA qna) throws SQLException {
			
			System.out.println("qua=" + qna);
			System.out.println("quan번호="+qna.getQaNo());
			QnA dbqna = qnaDAO.selectByNo(qna.getQaNo());	
			System.out.println(dbqna);
			System.out.println(dbqna.getPassword());
			
			
			if(!dbqna.getPassword().equals(qna.getPassword())){
			
				throw new SQLException("비밀번호가 일치하지 않습니다.");
				
				
			}
			int result = qnaDAO.update(qna);
			if(result==0) {
				throw new SQLException("수정 안되었어용요요");
			}
			
			return result;
			
			
		}
		
		public static int replyupdate(QnA qna) throws SQLException {
			
			System.out.println("qna=" + qna);
			System.out.println("qnaNum="+qna.getQaNo());
			System.out.println("qnaReply="+qna.getReply());
			QnA dbqna = qnaDAO.selectByNo(qna.getQaNo());	
			System.out.println(dbqna);
			System.out.println(dbqna.getPassword());
			
			
			int result = qnaDAO.replyupdate(qna);
			if(result==0) {
				throw new SQLException("수정 안되었어용요요");
			}
			
			return result;
			
			
		}
		
		
	
}
	
	
	

