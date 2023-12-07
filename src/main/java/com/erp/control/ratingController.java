package com.erp.control;

import com.erp.dao.EmployeeDao;
import com.erp.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ratingController", value = "/addrating")
public class ratingController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int empID = Integer.parseInt(req.getParameter("empID"));
        int rating = Integer.parseInt(req.getParameter("rating"));
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        int managerID = user.getUserId();
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.addRating(managerID, empID, rating);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/add-rating.jsp");

    }
}