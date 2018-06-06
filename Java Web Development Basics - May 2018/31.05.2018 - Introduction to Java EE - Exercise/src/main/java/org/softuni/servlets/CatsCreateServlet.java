package org.softuni.servlets;

import org.softuni.data.Cat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;


@WebServlet("/cats/create")
public class CatsCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("catsCreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("catName");
        String breed = req.getParameter("breed");
        String color = req.getParameter("color");
        Integer legs = Integer.parseInt(req.getParameter("legs"));

        Cat cat = new Cat(name, breed, color, legs);

        ((Map<String, Cat>)this.getServletContext().getAttribute("cats")).putIfAbsent(name, cat);


        resp.sendRedirect("/cats/profile?catName=" + name);
    }
}