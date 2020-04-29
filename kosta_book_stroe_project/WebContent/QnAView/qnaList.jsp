<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script>
$(document).ready(function() {
    var activeSystemClass = $('.list-group-item.active');

    //something is entered in search form
    $('#system-search').keyup( function() {
       var that = this;
        // affect all table rows on in systems table
        var tableBody = $('.table-list-search tbody');
        var tableRowsClass = $('.table-list-search tbody tr');
        $('.search-sf').remove();
        tableRowsClass.each( function(i, val) {
        
            //Lower text for case insensitive
            var rowText = $(val).text().toLowerCase();
            var inputText = $(that).val().toLowerCase();
            if(inputText != '')
            {
                $('.search-query-sf').remove();
                tableBody.prepend('<tr class="search-query-sf"><td colspan="6"><strong>Searching for: "'
                    + $(that).val()
                    + '"</strong></td></tr>');
            }
            else
            {
                $('.search-query-sf').remove();
            }

            if( rowText.indexOf( inputText ) == -1 )
            {
                //hide rows
                tableRowsClass.eq(i).hide();
                
            }
            else
            {
                $('.search-sf').remove();
                tableRowsClass.eq(i).show();
            }
        });
        //all tr elements are hidden
        if(tableRowsClass.children(':visible').length == 0)
        {
            tableBody.append('<tr class="search-sf"><td class="text-muted" colspan="6">No entries found.</td></tr>');
        }
    });
});

</script>
<style>
body {
    margin-top: 2%
}
</style>
<!------ Include the above in your HEAD tag ---------->
</head>
<body>
\${pageContext.request.contextPath} = ${pageContext.request.contextPath} 


<div class="container">
	<div class="row">
        <div class="col-md-3">
            <form action="#" method="get">
                <div class="input-group">
                    <!-- USE TWITTER TYPEAHEAD JSON WITH API TO SEARCH -->
                    <input class="form-control" id="system-search" name="q" placeholder="Search for" required>
                    <span class="input-group-btn">
                        <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
                    </span>
                </div>
            </form>
        </div>
		<div class="col-md-9">
    	 <table class="table table-list-search">
                    <thead>
                        <tr>
                            <th>글번호</th>
                            <th>글제목</th>
                            <th>작성자ID</th>
                            <th>등록일</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
    <c:when test="${empty requestScope.list}">
	   <tr>
        <td colspan="5">
            <p align="center"><b><span style="font-size:13pt;">등록된 게시물이 없습니다.</span></b></p>
        </td>
    </tr>
	    </c:when>
	    <c:otherwise>
		<c:forEach items="${requestScope.list}" var="bookDto">
			    <tr onmouseover="this.style.background='#eaeaea'"
			        onmouseout="this.style.background='white'">
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            ${bookDto.qaNo}</span></p>
			        </td>
			        <td bgcolor="">
						<p><span style="font-size:9pt;">
						<a href="book?command=read&qaNo=${bookDto.qaNo}">
						  ${bookDto.title}
						</a>
						</span></p>
			        </td>
			        
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            ${bookDto.customerId}</span></p>
			        </td>
			        <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            ${bookDto.regDt}</span></p>
			        </td>
			         
			         <td bgcolor="">
			            <p align="center"><span style="font-size:9pt;">
			            ${bookDto.readNum}</span></p>
			        </td>
			      
			    </tr>
	    </c:forEach>
		</c:otherwise>
	    </c:choose>
                    </tbody>
                </table>
                
            
		</div>
	</div>
	   <input type=button value="글쓰기" class="pull-right" onclick="javascript:location.href='${pageContext.request.contextPath}/QnAView/write.jsp'">
</div>







</body>
</html>