<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dao.TypeDAO" %>
<%@ page import="entity.Type" %>
<%@ page import="java.util.function.Function" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>New post</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Adding new post</h2>
    <form action="/projectX-database" method = "POST">
        <div class="form-group">
            <input type="text" class="form-control" id="post_body" name="post_body" placeholder="Text..." required>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<%
    TypeDAO typeDAO = new TypeDAO();

    if(request.getParameter("post_body") != null) {
        typeDAO.create(new Type(0, request.getParameter("post_body")));
    }
%>

</body>
</html>
