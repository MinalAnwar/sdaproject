package com.erp.control;


import com.erp.entity.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "assTaskdeleteControl", value = "/assigntaskdelete")
public class assignTaskdeleteControl extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String orderId = request.getParameter("orderID");
        int employeeId = Integer.parseInt(request.getParameter("employeeID"));
        Admin user = new Admin();
        boolean deletionCheck = user.deleteAssignedTask(orderId,employeeId);
        if (deletionCheck)
            response.sendRedirect(request.getContextPath() + "/allAssigned-tasks.jsp");
        else {
            request.setAttribute("valid", deletionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/allAssigned-tasks.jsp");
            view.forward(request, response);
        }
    }

}
