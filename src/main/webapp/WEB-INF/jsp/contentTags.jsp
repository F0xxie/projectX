<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <h2>Content tags</h2>
    <p>The join table of tags and content:</p>
    <table id="content_tags_table" class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>Content ID</th>
            <th>Tag ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var = "content_tags" items = "${content_tags}">
            <tr>
                <td><c:out value="${content_tags.id}"/></td>
                <td><c:out value="${content_tags.j_type_id}"/></td>
                <td><c:out value="${content_tags.j_tag_id}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<div class="container">
    <a href="contenttags/new" class="btn btn-primary" role="button">Add</a>
</div>

</body>
</html>