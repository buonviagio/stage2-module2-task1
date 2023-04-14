package com.example.servlet;

import com.example.Warehouse;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class GetUsersServlet extends HttpServlet {

    String path;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Warehouse warehouse = Warehouse.getInstance();
        req.setAttribute("users", warehouse.getUsers());
        ServletContext servletContext = getServletContext();
        path = getServletConfig().getInitParameter("pathToUsersJsp");
        servletContext.getRequestDispatcher(path).forward(req, resp);
    }
}
