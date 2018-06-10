<%@ page import="org.softuni.data.Cat" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 06.06.2018 г.
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Fluffy Duffy Munchkin Cats</title>
</head>
<body>
    <% String catName = request.getQueryString().split("=")[1]; %>

    <% Cat cat = ((Map<String, Cat>) application.getAttribute("cats")).get(catName); %>

    <% if(cat != null) {%>
    <h1>Cat - <%= cat.getName() %> </h1>
    <hr/>
    <h3>Breed: <%=cat.getBreed() %></h3>
    <h3>Color: <%=cat.getColor() %></h3>
    <h3>Number Of Legs: <%=cat.getNumberOfLegs().toString() %></h3>
    <hr/>
    <% } else { %>
    <h1>Cat, with name - <%=catName %> was not found.</h1>
    <% } %>
    <a href="/">Back</a>
</body>
</html>