<%@ page import="org.softuni.fdmc.data.repos.UserRepository" %>
<%@ page import="org.softuni.fdmc.data.models.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: atriu
  Date: 1.6.2018 г.
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
</head>
<body>
<h1>Register!</h1>
<br/>
    <form method="post" action="/users/register">
        Username: <input type="text" name="username" /><br/>
        Password: <input type="password" name="password" /><br/>
        Confirm Password: <input type="password" name="confirmPassword" /><br/>
        <hr>
        <% if(((UserRepository) application.getAttribute("users")).isThereAnyUsers()) {%>
                <h3>you can be only regular user</h3>
                <% } else { %>
                 <h3><input type="checkbox" name="role">be Admin</h3>
        <% } %>
        <button type="submit">Register</button>
    </form>
    <br/>
    <a href="/">Back to Home</a>
</body>
</html>
