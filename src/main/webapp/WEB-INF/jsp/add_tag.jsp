<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Tag management</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Tag control:</h2>
    <form>
        <div class="form-group">
            <input type="text" class="form-control" name = "tag" placeholder="Tag" required>
        </div>
        <button type="submit" class="btn btn-primary" id="tag_add">Save</button>
        <a href="/tags" class="btn btn-primary" role="button">Cancel</a>
    </form>
    <br>
</div>

</body>
</html>