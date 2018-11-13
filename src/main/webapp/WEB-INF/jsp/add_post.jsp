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
    <a href="/"><< Back</a>
    <br>
    <h2>Adding new post</h2>
    <br>
    <label for="tfield">Enter text:</label>
    <textarea class="form-control" rows="5" id="tfield" name="postbody" form="text_body_field"></textarea>
    <form action="add_post.jsp" method = "POST" id="text_body_field">
        <button type="submit" class="btn btn-primary" id="post_add">Submit</button>
    </form>
</div>

<%
    TypeDAO typeDAO = new TypeDAO();

    if(request.getParameter("postbody") != null) {
        String postbody = request.getParameter("postbody");
        String final_pbody = postbody.replace("'", "`");
        typeDAO.create(new Type(0, final_pbody));
    }
%>

</body>
</html>
