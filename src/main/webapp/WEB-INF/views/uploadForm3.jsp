<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title></head><body>
<div class="container">
<form action="upload3.do" method="post" enctype="multipart/form-data">
<table class="table table-bordered">
	<caption class="text-primary">회원정보</caption>
	<tr><td>아이디</td><td><input type="text" name="id"
		required="required" autofocus="autofocus"></td></tr>
	<tr><td>이름</td><td><input type="text" name="name"
		required="required"></td></tr>
	<tr><td>사진<span class="glyphicon glyphicon-picture"></span>
	</td><td><input type="file" name="file" multiple="multiple"
		required="required"></td></tr>
	<tr><td colspan="2"><input type="submit"></td></tr>
</table>
</form>
</div>
</body>
</html>