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

@WebServlet("/cats/create")
public class CatCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        out.println("<h1> Create a Cat!</h1>");
        out.println("<form method=\"post\" action=\"/cats/create\">");
        out.println("Name: <input type=\"text\" name=\"name\"><br>");
        out.println("Breed: <input type=\"text\" name=\"breed\"><br>");
        out.println("Color: <input type=\"text\" name=\"color\"><br>");
        out.println("Number of legs: <input type=\"number\" name=\"numberOfLegs\"><br>");
        out.println("<input type=\"submit\" value=\"Create Cat\"><br>");
        out.println("<p><a href=\"/\">Back to Home</a></p>");
        out.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String color = req.getParameter("color");
        int legs = Integer.parseInt(req.getParameter("numberOfLegs"));

        Cat cat = new Cat(name, breed, color, legs);

        ((Map<String, Cat>)this.getServletContext().getAttribute("cats")).putIfAbsent(name, cat);

        resp.sendRedirect("/cats/profile?name=" + name);
    }
}