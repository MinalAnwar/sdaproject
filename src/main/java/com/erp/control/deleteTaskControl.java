package com.erp.control;

import com.erp.entity.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "deleteTaskControl", value = "/taskdelete")
public class deleteTaskControl extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int taskID = Integer.parseInt(request.getParameter("taskID"));
        Admin user = new Admin();
        boolean deletionCheck = user.deleteTask(taskID);
        if (deletionCheck)
            response.sendRedirect(request.getContextPath() + "/all-employee.jsp");
        else {
            request.setAttribute("valid", deletionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/all-employee.jsp");
            view.forward(request, response);
        }
    }
}
