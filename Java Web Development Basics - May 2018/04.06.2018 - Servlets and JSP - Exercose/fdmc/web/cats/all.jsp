<%@ page import="org.softuni.fdmc.data.models.Cat" %>
<%@ page import="org.softuni.fdmc.data.repos.CatRepository" %>
<%@ page import="java.util.Set" %>
<%--
  Created by IntelliJ IDEA.
  User: atriu
  Date: 1.6.2018 г.
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FDMC</title>
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="shortcut icon" href="/images/favicon.ico">
</head>
<body>
    <h1>All Cats</h1>
    <hr />
    <% response.setIntHeader("Refresh", 3);

    Set<Cat> cats = ((CatRepository) application.getAttribute("cats")).getAllCatsSorted();

    for(Cat cat : cats) {
        String debug = ("<h3> <a href=\"/cats/profile?catName=" + cat.getName() + "\">" + cat.getName() + "</a></h3>\n");
        out.println(debug);
    } %>
    <br />
    <a href="/">Back to Home</a>
</body>
</html>
