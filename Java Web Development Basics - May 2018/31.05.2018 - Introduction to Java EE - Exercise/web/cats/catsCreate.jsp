
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fluffy Duffy Munchkin Cats</title>
</head>
<body>

    <h1>Create a Cat!</h1>
        <form method="post" action="/cats/create">
        <h4>Name:
           <input type="text" id="catName" name="catName" placeholder="Enter name"></h4>
        <h4> Breed:
            <input type="text" id="breed" name="breed" placeholder="Enter breed"></h4>
        <h4>Color:
            <input type="text" id="color" name="color" placeholder="Enter color"></h4>
        <h4>Number of legs
            <input type="number" id="legs" name="legs" placeholder="Enter number of legs"></h4>
            <input type="submit" value="Create Cat">
        </form>
        <br>
        <a href="/">Back To Home</a>
</body>
</html>