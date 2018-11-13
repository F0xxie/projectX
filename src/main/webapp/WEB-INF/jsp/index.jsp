<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.Type" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Main page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <a href="users">users</a> <%-- Иначе не работает на моём компьютере, не знаю, в чём причина --%>
    <br><br><br>
    <h2>Main page</h2>
    <p>Nothing to see here</p>
    <form action = "add_post.jsp" method = "POST">
    <input type = "submit" name="post_redirect" value = "Add post"/>
    </form>
    <br>
    <table class="table table-borderless table-hover">
        <tbody>
        <%
            List<Type> posts = (ArrayList<Type>)request.getAttribute("posts");
            pageContext.setAttribute("post", posts);
        %>
        <c:forEach var = "post" items = "${posts}">
        <tr>
            <td><c:out value="${post.type}"/></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>