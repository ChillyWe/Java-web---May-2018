package org.softuni.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cats/profile")
public class CatsProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("catsProfile.jsp").forward(req, resp);

//        String queryString = req.getQueryString();
//        String name = queryString.split("=")[1];

//        if (cats == null) {
//
//            pageContent.append("<html>")
//                    .append("<h1>Cat, with name - " + name + " was not found.</h1>\n")
//                    .append("<a href=\"<c:url value=\"/\"/\">Back</a>")
//                    .append("</html>");
//
//            out.println(pageContent);
//
//        } else {
//            pageContent.append("<html>")
//                    .append("<h1>Cat - " + neededCat.getName() + "</h1>\n")
//                    .append(" <hr/>").append("\n\r")
//                    .append("<h3> Breed: " + neededCat.getBreed() + "</h3>\n")
//                    .append("<h3> Color: " + neededCat.getColor() + "</h3>\n")
//                    .append("<h3> Number of legs: " + neededCat.getNumberOfLegs() + "</h3>\n")
//                    .append(" <hr/>").append("\n\r")
//                    .append("<a href=\"<c:url value=\"/\"/\">Back</a>")
//                    .append("</html>");
    }
}