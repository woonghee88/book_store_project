<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Write something else you want</title>
 <link rel="stylesheet" href="css/style.css">
<script src="js/jquery-3.4.1.min.js"></script> 
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
 <link rel="stylesheet" href="css/style.css">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
 
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


<SCRIPT language=javascript>
function sendUpdate(){//수정폼
	document.requestForm.command.value ="updateForm";
	document.requestForm.submit();
}

function sendDelete(){//삭제
	if(document.requestForm.password.value==""){
		alert("삭제를 위한 비밀번호를 입력해주세요.");
		document.requestForm.password.focus();
		return;
	}
	
	document.requestForm.command.value ="delete";
	document.requestForm.submit();
}

function sendReply(){
	
	document.requestForm.command.value ="replyForm";
	document.requestForm.submit();
	
}

</script>


</head>
<body>


  
<div class="container">
<table class="table table-bordered">
    <thead>
        <caption> 게시물 자세히 보기  </caption>
    </thead>
    <tbody>
			<tr>
				<th>글번호: </th>
				<td width="450" height="20" colspan="3">
        		<span style="font-size:9pt;"><b>${book.qaNo}</b></span>	</td>
        	</tr>
            <tr>
                <th>제목: </th>
             	<td width="450" height="20" colspan="3">
        		<span style="font-size:9pt;"><b>${book.title}</b></span>	</td>
            	
            </tr>
            
            <tr>
                <th>내용: </th>
               	<td width="450" height="20" colspan="3">
        		<span style="font-size:9pt;"><b>${book.qaContent}</b></span>	</td>
            </tr>
            <tr>
            	<th>답변: </th>
               	<td width="450" height="20" colspan="3">
        		<span style="font-size:9pt;"><b>${book.reply}</b></span>	</td>
            </tr>
                 
            <c:if test="${book.fname!=null}">
      	 		<tr>
        		<td width="100" height="20">
            	<p align="right"><b><span style="font-size:9pt;">다운로드</span></b></p>
       		 </td>
        	<td width="450" height="20" colspan="3">
        	<span style="font-size:9pt;"><b>
        	<a href='downLoad?fName=${book.fname}'>
    			${book.fname} 
      		</a>
      		  ( <fmt:formatNumber value="${book.fsize}"/> byte)
        	</b></span>
       		 </td> 
    		</tr>
    		</c:if>
                      
            <tr>
             <th>비밀번호: </th>
		  
		        <form name="requestForm" method=post action="${pageContext.request.contextPath}/book">
		        <td height="20" colspan="3" align="left" valign="middle">
						<input type=password name="password" value="", class="form-control">
						*글 수정 및 삭제시 필요* 		
				</td>
		    </tr>
            
            
            
            <tr>
       		<td height="20" colspan="4" align="center" valign="middle">
			<!-- 수정시 필요한 데이터들을 hidden으로 숨겨놓고 폼 데이터로 보내준다. -->
				<input type=hidden name="qaNo" value="${book.qaNo}">
				<input type=hidden name="command" value="">
				<input type=button value="수정하기" onClick="sendUpdate()">
				<input type=button value="삭제하기" onClick="sendDelete()">
				<input type=button value="글목록"	onclick="javascript:location.href='${pageContext.request.contextPath}/book?command=list'">
    			<input type=button value="답변 하기" onClick="sendReply()" class="pull-right">
    		</form>
				
			</td>
  			</tr>
            
       
      
    </tbody>
</table>
</div>

</body>
</html>


