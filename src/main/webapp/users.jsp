<%@ page import="entity.User" %>
<%@ page import="dao.UserDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <title>Users table</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        td, th {
            border: 1px solid #000000;
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>

<body>
<h2>Users:</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Password</th>
    </tr>
    <%
    List<User> mass = (ArrayList<User>)request.getAttribute("users");
    for (User user : mass) {
    %>
    <tr>
        <td><% out.print(user.getId()); %></td>
        <td><% out.print(user.getLogin()); %></td>
        <td><% out.print(user.getPassword()); %></td>
    </tr>
    <%
    }
    %>
</table>
<br>

<form action = "users.jsp" method = "POST">
    <input type = "text" name = "first_name" placeholder="Username">
    <br />
    <input type = "text" name = "last_name" placeholder="Password"/>
    <br>
    <input type = "submit" name="user_add" value = "Submit"/>
</form>

<form action="users.jsp" method = "POST">
    <input type = "text" name = "user_id" placeholder="ID to delete">
    <br />
    <input type="submit" name="user_delete" value="Delete">
</form>


<%
    UserDAO userDAO = new UserDAO();
    if(request.getParameter("user_add") != null) {
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