package org.softuni.fdmc.servlets.cats;

import org.softuni.fdmc.data.models.Cat;
import org.softuni.fdmc.data.models.Order;
import org.softuni.fdmc.data.models.User;
import org.softuni.fdmc.data.repos.CatRepository;
import org.softuni.fdmc.data.repos.OrderRepository;
import org.softuni.fdmc.data.repos.UserRepository;

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
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User client = ((UserRepository)this.getServletContext().getAttribute("users")).getByUsername(req.getSession().getAttribute("username").toString());

        String buttonValue = req.getParameter("catName");
        String catName = buttonValue.substring(6, buttonValue.length());
        Cat cat = ((CatRepository) this.getServletContext().getAttribute("cats")).getByName(catName);

        if (client != null && cat != null) {
            Order order = new Order();
            order.setClient(client);
            order.setCat(cat);
            ((OrderRepository)this.getServletContext().getAttribute("orders")).addOrder(order);
            resp.sendRedirect("/");
            return;
        }

        resp.sendRedirect("/");
    }
}
