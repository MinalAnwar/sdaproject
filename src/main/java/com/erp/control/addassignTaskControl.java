package com.erp.control;

import com.erp.entity.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addassignTaskControl", value = "/assigntask")
public class addassignTaskControl extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                String date = request.getParameter("date");
                String orderId = request.getParameter("orderid");
                int employeeId = Integer.parseInt(request.getParameter("employeeid"));
        if(employeeId<0||orderId==null)
        {
            request.setAttribute("valid", false);
            RequestDispatcher view = request.getRequestDispatcher("/assign-task.jsp");
            view.forward(request, response);
            return;
        }
        //in controller, we get the data from fields and make obj then call this function of admin
        Admin user = new Admin();
        boolean insertionCheck = user.assignTask(date,orderId,employeeId);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/assign-task.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/assign-task.jsp");
            view.forward(request, response);
        }
    }
}
