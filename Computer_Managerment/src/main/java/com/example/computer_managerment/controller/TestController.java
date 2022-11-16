package com.example.computer_managerment.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet( name = "TestController" , urlPatterns = "/test")
public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("date", new Date());
        req.setAttribute("price", 1003434600.0667f);
        System.out.println(new Date());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/test.jsp");
        requestDispatcher.forward(req, resp);
    }
}
