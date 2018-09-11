<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Oh look, them buttons</title>
</head>

<body>
	<%
	if(request.getParameter("users") != null) {
	%>
	<jsp:forward page="users.jsp"></jsp:forward>
	<%
	return;
	}
	%>
	<form action="index.jsp" method = "POST">
		<input type="submit" name="users" value="Users">
	</form>
	<form action="index.jsp" method = "POST">
		<input type="submit" name="content" value="Content">
	</form>
	<form action="index.jsp" method = "POST">
		<input type="submit" name="types" value="Types">
	</form>
</body>
</html>
