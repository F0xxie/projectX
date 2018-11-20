<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="entity.User" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="dao.JdbcUserDAO" %>

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

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .icon {
            background-color: Black;
            border: none;
            color: white;
            padding: 0px 6px;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="container">
    <a href="/"><< Back</a>
    <br>
    <h2>Users</h2>
    <p>The list of users:</p>
    <table id="users_table" class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Password</th>
            <th width="85px"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var = "user" items = "${users}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.password}"/></td>
            <td width="85px">
                <%-- <button type="submit" class="icon"><i class="fa fa-edit"></i></button> --%>
                <form>
                    <input type="hidden" name="userId" value="${user.id}">
                    <button type="submit" class="icon"><i class="fa fa-trash"></i></button>
                </form>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="container">
    <a href="users/new" class="btn btn-primary" role="button">New user</a>
</div>

</body>
</html>