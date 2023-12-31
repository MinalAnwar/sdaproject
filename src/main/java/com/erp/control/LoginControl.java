package com.erp.control;

import com.erp.dao.SystemWorks;
import com.erp.entity.Inventory;
import com.erp.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginControl", value = "/login")
public class LoginControl extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        SystemWorks obj = new SystemWorks();
        boolean isValid = obj.checkCredentials(request.getParameter("email"), request.getParameter("password"));
        if (isValid) {
            // make an obj of inventory for this session
            HttpSession session = request.getSession();
            Inventory inventory = (Inventory) session.getAttribute("inventory");

            // If the inventory object doesn't exist, create a new one and store it in the session
            if (inventory == null) {
                inventory = new Inventory();
                session.setAttribute("inventory", inventory);
            }

            User user = null;
            user =obj.getDesignation(request.getParameter("email"),request.getParameter("password"));
            session.setAttribute("designation",user.getDesignation());
            session.setAttribute("user",user);
            response.sendRedirect(request.getContextPath() + "/dashboard");
        }
        else {
            request.setAttribute("valid", isValid);
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            view.forward(request, response);
        }
    }
}