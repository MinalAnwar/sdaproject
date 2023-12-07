package com.erp.control;

import com.erp.entity.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "deleteVendorControl", value = "/vendordelete")
public class deleteVendorControl extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int vendorId = Integer.parseInt(request.getParameter("vendorID"));
        Admin user = new Admin();
        boolean deletionCheck = user.deleteVendor(vendorId);
        if (deletionCheck)
            response.sendRedirect(request.getContextPath() + "/all-vendors.jsp");
        else {
            request.setAttribute("valid", deletionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/all-vendors.jsp");
            view.forward(request, response);
        }
    }
}
