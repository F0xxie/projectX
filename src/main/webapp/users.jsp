<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.User" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Users table</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Users</h2>
    <p>The list of users:</p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Password</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<User> user = (ArrayList<User>)request.getAttribute("users");
            pageContext.setAttribute("users", user);
        %>
        <c:forEach var = "user" items = "${users}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.password}"/></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="container">
    <h2>User control:</h2>
    <p>Add user</p>
    <form action="users.jsp" method = "POST">
        <div class="form-group">
            <input type="text" class="form-control" name = "first_name" placeholder="Username">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="last_name" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary" id="user_add">Submit</button>
    </form>
    <br>
    <p>Remove user</p>
    <form action="users.jsp" method = "POST">
        <div class="form-group">
            <input type="text" class="form-control" name = "user_id" placeholder="ID for deletion">
        </div>
        <button type="submit" class="btn btn-primary" id="user_delete">Submit</button>
    </form>
</div>

<%
    UserDAO userDAO = new UserDAO();

    if(request.getParameter("first_name") != null) {
        if(!request.getParameter("first_name").equals("") && !request.getParameter("last_name").equals("")) {
            userDAO.create(new User(0, request.getParameter("first_name"), request.getParameter("last_name")));
        }
    }

    if(request.getParameter("user_id") != null) {
        if(!request.getParameter("user_id").equals("")) {
            userDAO.remove(new User(Integer.parseInt(request.getParameter("user_id")), "", ""));
        }
    }
%>

</body>
</html>