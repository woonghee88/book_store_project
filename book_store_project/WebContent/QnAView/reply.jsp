
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<script>
function checkValid() {
    var f = window.document.updateForm;
		
	if ( f.title.value == "") {
	    alert( "제목을 입력해 주세요." );
	    f.model_num.focus();
		return false;
    }
	if ( f.content.value == "" ) {
		alert( "내용을 입력해 주세요." );
		f.model_name.focus();
		return false;
	}
	if ( f.password.value == "" ) {
        alert( "비밀번호를 입력해 주세요" );
        f.password.focus();
        return false;
    }
	
    return true;
}

</script>

</head>
<body>
<form name=replyForm method=post action="book" onSubmit="return checkValid()">
    <input type="hidden" name="command" value="reply" >
    <input type='hidden' name='qaNo' value="${book.qaNo}">
    
    
    
<div class="container">
	<table class="table table-bordered">
<caption> 수정하기</caption>
		
				

	
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
                <td><textarea cols="15"  name="reply" class="form-control"></textarea></td>
            </tr>
            <tr>
                <th>파일첨부: </th>
                <td><input type="file"  name="filename" class="form-control"/></td>
            </tr>

                <td colspan="2">
                	<input type="button" value=" 글 목록 " class="pull-right" onclick="javascript:location.href='book?command=list'"/>
                   	<input type="submit" value="답변하기" class="pull-right">	
                    <input type="button" value="reset" class="pull-left"/>
                   
                    <!-- <a class="btn btn-default" onclick="sendData()"> 등록 </a>
                    <a class="btn btn-default" type="reset"> reset </a>
                    <a class="btn btn-default" onclick="javascript:location.href='list.jsp'">글 목록으로...</a> -->
                </td>
            </tr>
       
    </tbody>
</table>
</div>
</form>
</body>
</html>


