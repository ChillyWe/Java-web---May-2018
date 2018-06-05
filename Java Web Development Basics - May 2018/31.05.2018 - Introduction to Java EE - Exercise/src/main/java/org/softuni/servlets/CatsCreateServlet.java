package org.softuni.servlets;

import org.softuni.data.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cats/create")
public class CatsCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        StringBuilder textContent = new StringBuilder();

        textContent.append("<html>" +
                "<form method=\"post\"\">" +
                " <h1>Create a Cat!</h1>" +
                "<h4>Name:" +
                "  <input type=\"text\" id=\"catName\" name=\"catName\" placeholder=\"Enter name\"></h4>\n" +
                " <h4> Breed:" +
                "  <input type=\"text\" id=\"breed\" name=\"breed\" placeholder=\"Enter breed\"></h4>\n" +
                "<h4>Color:" +
                "  <input type=\"text\" id=\"color\" name=\"color\" placeholder=\"Enter color\"></h4>\n" +
                "<h4>Number of legs:" +
                "  <input type=\"number\" id=\"legs\" name=\"legs\" placeholder=\"Enter number of legs\"></h4>\n" +
                "  <input type=\"submit\" value=\"Create Cat\">\n" +
                "</form>" +
                "<a href=\"<c:url value=\"/\"/\">Back To Home</a>" +
                "</html>");

        out.println(textContent.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("catName");
        String breed = req.getParameter("breed");
        String color = req.getParameter("color");
        int legs = Integer.parseInt(req.getParameter("legs"));

        Cat cat = new Cat(name, breed, color, legs);

        Map<String, Cat> cats = (Map<String, Cat>) this.getServletConfig().getServletContext().getAttribute("cats");

        if (cats == null) {
            cats = new HashMap<>();
        }

        cats.putIfAbsent(name, cat);

        this.getServletConfig().getServletContext().setAttribute("cats", cats);

        resp.sendRedirect("/cats/profile?catName=" + cats.get(name).getName());
    }
}