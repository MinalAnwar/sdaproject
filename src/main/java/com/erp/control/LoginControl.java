package com.erp.control;

import com.erp.dao.AccountDao;
import com.erp.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginControl", value = "/login")
public class LoginControl extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AccountDao user = new AccountDao();
        boolean isValid = user.checkCredentials(request.getParameter("email"), request.getParameter("password"));
        if (isValid)
            response.sendRedirect(request.getContextPath() + "/dashboard.html");
        else {
            request.setAttribute("valid", isValid);
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            view.forward(request, response);
        }
    }
}