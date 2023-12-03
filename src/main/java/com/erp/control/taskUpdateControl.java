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

@WebServlet(name = "taskUpdateControl", value = "/taskupdate")
public class taskUpdateControl extends HttpServlet {
    //'taskupdate?taskId=' + inputValues[0] + '&taskName=' + inputValues[1] + '&taskDescription=' + inputValues[2] + '&taskstatus=' + inputValues[3] + '&taskdeadline=' + inputValues[4]+ '&oldID=' + arr[0],
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Task obj = new Task(
                Integer.parseInt(request.getParameter("taskId")),
                request.getParameter("taskName"),
                request.getParameter("taskDescription"),
                request.getParameter("taskstatus"),
                request.getParameter("taskdeadline")
        );

        if(Integer.parseInt(request.getParameter("taskId"))<0)
        {
            request.setAttribute("valid", false);
            RequestDispatcher view = request.getRequestDispatcher("/all-tasks.jsp");
            view.forward(request, response);
            return;
        }
        Admin user = new Admin();
        boolean insertionCheck = user.updateTask(Integer.parseInt(request.getParameter("oldID")),obj);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/all-tasks.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/all-tasks.jsp");
            view.forward(request, response);
        }

    }
}
