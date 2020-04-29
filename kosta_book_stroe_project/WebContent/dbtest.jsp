
<%@page import="kbs.mvc.model.domain.Levels"%>
<%@page import="com.sun.glass.ui.Window.Level"%>
<%@page import="kbs.mvc.model.dao.LevelDAOImpl"%>
<%@page import="kbs.mvc.model.dao.DeliveryDAOImpl"%>
<%@page import="kbs.mvc.model.domain.QnA"%>
<%@page import="kbs.mvc.model.dao.QnADAOImpl"%>
<%@page import="kbs.mvc.model.domain.Review"%>
<%@page import="kbs.mvc.model.dao.ReviewDAOImpl"%>
<%@page import="kbs.mvc.util.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
연결 : <%--=DBUtil.getConnection()--%>
<%
	LevelDAOImpl levDAO = new LevelDAOImpl();
	Levels levels = new Levels(2,40,10000,100000);
	
	out.println(levDAO.insert(levels));
	
%>


</body>
</html>