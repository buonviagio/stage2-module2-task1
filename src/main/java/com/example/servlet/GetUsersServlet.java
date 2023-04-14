package com.example.servlet;

import com.example.Warehouse;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/users")
public class GetUsersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Warehouse warehouse = Warehouse.getInstance();
        req.setAttribute("users", warehouse.getUsers());
        //ServletContext servletContext = getServletContext();
        //servletContext.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
        req.getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
    }
}
