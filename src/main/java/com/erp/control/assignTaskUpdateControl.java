package com.erp.control;


import com.erp.entity.Admin;
import com.erp.entity.Task;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "assignTaskUpdateControl", value = "/assignedtaskupdate")
public class assignTaskUpdateControl extends HttpServlet {
    //'assignedtaskupdate?date=' + inputValues[0] + '&orderID=' + inputValues[1] + '&employeeID=' + inputValues[2] + '&oldOrderID=' + arr[1] + '&oldEmployeeID=' + arr[2],

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                String date = request.getParameter("date");
                String orderid = request.getParameter("orderID");
                int employeeid = Integer.parseInt(request.getParameter("employeeID"));
                String oldOrderid = request.getParameter("oldOrderID");
                int oldEmployeeid = Integer.parseInt(request.getParameter("oldEmployeeID"));
        if(orderid ==null || employeeid<0)
        {
            request.setAttribute("valid", false);
            RequestDispatcher view = request.getRequestDispatcher("/allAssigned-tasks.jsp");
            view.forward(request, response);
            return;
        }
        Admin user = new Admin();
        boolean insertionCheck = user.updateAssignTask(date,orderid,employeeid,oldOrderid,oldEmployeeid);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/allAssigned-task.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/allAssigned-task.jsp");
            view.forward(request, response);
        }

    }

}
