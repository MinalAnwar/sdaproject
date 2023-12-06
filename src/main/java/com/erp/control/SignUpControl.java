package com.erp.control;

import com.erp.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUpControl", value = "/signUp")

public class SignUpControl extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confrimPassword = request.getParameter("confirmPassword");
        User obj = new User();
        boolean insertionCheck = obj.signup(username,password,confrimPassword);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            view.forward(request, response);
        }


    }

}
