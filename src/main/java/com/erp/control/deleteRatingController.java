package com.erp.control;

import com.erp.entity.Manager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteRatingController", value = "/deleteRating")
public class deleteRatingController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("inside controller");
        int empid = Integer.parseInt(request.getParameter("empID"));
        int managerId= Integer.parseInt(request.getParameter("managerID"));
        Manager user = new Manager();
        boolean deletionCheck = user.deleteRating(empid,managerId);
        if (deletionCheck)
            response.sendRedirect(request.getContextPath() + "/all-products.jsp");
        else {
            request.setAttribute("valid", deletionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/all-products.jsp");
            view.forward(request, response);
        }
    }

}
