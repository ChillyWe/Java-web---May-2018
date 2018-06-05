package org.softuni.servlets;

import org.softuni.data.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/cats/profile")
public class CatsProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        StringBuilder pageContent = new StringBuilder();

        Map<String, Cat> cats = (Map<String, Cat>) this.getServletConfig().getServletContext().getAttribute("cats");

        String queryString = req.getQueryString();
        String name = queryString.split("=")[1];

        if (cats == null) {

            pageContent.append("<html>")
                    .append("<h1>Cat, with name - " + name + " was not found.</h1>\n")
                    .append("<a href=\"<c:url value=\"/\"/\">Back</a>")
                    .append("</html>");

            out.println(pageContent);

        } else {
            Cat neededCat = cats.get(name);

            pageContent.append("<html>")
                    .append("<h1>Cat - " + neededCat.getName() + "</h1>\n")
                    .append(" <hr/>").append("\n\r")
                    .append("<h3> Breed: " + neededCat.getBreed() + "</h3>\n")
                    .append("<h3> Color: " + neededCat.getColor() + "</h3>\n")
                    .append("<h3> Number of legs: " + neededCat.getNumberOfLegs() + "</h3>\n")
                    .append(" <hr/>").append("\n\r")
                    .append("<a href=\"<c:url value=\"/\"/\">Back</a>")
                    .append("</html>");

            out.println(pageContent.toString());
        }
    }
}