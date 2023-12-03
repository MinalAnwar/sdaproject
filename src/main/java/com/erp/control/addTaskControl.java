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

@WebServlet(name = "addTaskControl", value = "/addTask")
public class addTaskControl extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Task obj = new Task(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("description"),
                request.getParameter("status"),
                request.getParameter("deadline")
        );
        if(Integer.parseInt(request.getParameter("id"))<0)
        {
            request.setAttribute("valid", false);
            RequestDispatcher view = request.getRequestDispatcher("/add-task.jsp");
            view.forward(request, response);
            return;
        }
        //in controller, we get the data from fields and make obj then call this function of admin
        Admin user = new Admin();
        boolean insertionCheck = user.addTask(obj);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/add-task.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/add-task.jsp");
            view.forward(request, response);
        }
    }

}
