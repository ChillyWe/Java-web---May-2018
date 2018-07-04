<%@ page import="org.softuni.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="org.softuni.repos.ProductRepository" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 01.07.2018 г.
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="username" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple JSP</title>
</head>
<body>
    <h1>All Products</h1>
    <%
        List<Product> products = ((ProductRepository)application.getAttribute("products")).getAllProducts(); %>
<hr/>
<% for (Product product : products) { %>
    <h1> <%= product.getName() %></h1>
       <%--<h1><a href="products/details?name=<%= product.getName() %>"><%= product.getName() %> </a> </h1>--%>
    <% } %>
</body>
</html>