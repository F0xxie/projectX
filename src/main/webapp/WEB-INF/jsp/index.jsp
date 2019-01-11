<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <style>
        tr {
            text-align: justify;
        }
    </style>
</head>
<body>

<div class="container">
    <a href="users">users</a>
    <a href="tags">tags</a>
    <br><br><br>
    <h2>Main page</h2>
    <p>Nothing to see here</p>
    <a href="newpost" class="btn btn-info" role="button">Add post</a>
    <br><br>
    <table class="table table-borderless table-hover">
        <tbody>
        <c:forEach var = "post" items = "${posts}">
        <tr>
            <td>
                <c:out value="${post.type}"/>
                <br>
                <c:out value="${post.id} | " />
                <c:out value="#placeholder"/>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>