<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dao.JdbcTypeDAO" %>
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
    <br>
    <h2>New post</h2>
    <br>
    <textarea class="form-control" rows="5" id="tfield" name="postbody" form="text_body_field" required></textarea>
    <br>
    <form id="text_body_field">
        <button type="submit" class="btn btn-primary" id="post_add">Add</button>
        <a href="/" class="btn btn-primary" role="button">Cancel</a>
    </form>
</div>
</body>
</html>
