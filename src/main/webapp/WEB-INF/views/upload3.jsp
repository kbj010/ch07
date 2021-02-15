<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<title>Insert title here</title></head><body>
<h2>업로드 결과</h2>
아이디 : ${id }<p>
이름 : ${name }<p>
파일명  <br>
<c:forEach var="fileName" items="${fileList }">
	${fileName }<br>
</c:forEach>
</body>
</html>