package com.example.servlet;

import com.example.Warehouse;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/users")
public class GetUsersServlet extends HttpServlet {
    String path = "/jsp/users.jsp";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Warehouse warehouse = Warehouse.getInstance();
        req.setAttribute("users", warehouse.getUsers());
        ServletContext servletContext = getServletContext();
        servletContext.getRequestDispatcher(path).forward(req, resp);
    }
}
