package com.example.computer_managerment.controller;

import com.example.computer_managerment.dao.AccountDAO;
import com.example.computer_managerment.dao.CountryDAO;
import com.example.computer_managerment.dao.IAccountDAO;
import com.example.computer_managerment.dao.ICountryDAO;
import com.example.computer_managerment.model.Account;
import com.example.computer_managerment.model.Country;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login", ""})
public class LoginServlet extends HttpServlet {
    private IAccountDAO iAccountDAO;
    private ICountryDAO iCountryDAO;

    @Override
    public void init() throws ServletException {
        iAccountDAO = new AccountDAO();
        iCountryDAO = new CountryDAO();
        List<Country> listCountry  = iCountryDAO.selectAllCountry();
        if (this.getServletContext().getAttribute("listCountry ") == null){
            this.getServletContext().setAttribute("listCountry", listCountry);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/account/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        List<Account> accountList = iAccountDAO.selectAllAccount();
        boolean flag = true;
        for (Account account : accountList){
            if (account.getEmail().equals(email) && account.getPassword().equals(password)){
                req.getSession().setAttribute("email", email);
                req.getSession().setAttribute("password", password);
                resp.sendRedirect("/product");
                return;
            }
        }
        if (flag) {
            req.setAttribute("message", "Ban nhap sai tai khoan hoac mat khau khong dung!");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/account/login.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
