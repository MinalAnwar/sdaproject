package com.erp.control;

import com.erp.entity.Admin;
import com.erp.entity.Vendor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@WebServlet(name = "addVendorControl", value = "/addVendor")
public class addVendorControl extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Vendor obj = new Vendor(
                Integer.parseInt(request.getParameter("vendorId")),
                request.getParameter("name"),
                Integer.parseInt(request.getParameter("rating")),
                request.getParameter("phoneNumber"),
                request.getParameter("email")
        );
        final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        final Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(request.getParameter("email"));
        if(Integer.parseInt(request.getParameter("vendorId"))<0||Integer.parseInt(request.getParameter("rating"))<0||Integer.parseInt(request.getParameter("rating"))>5 || !matcher.matches() )
        {
            request.setAttribute("valid", false);
            RequestDispatcher view = request.getRequestDispatcher("/add-vendors.jsp");
            view.forward(request, response);
            return;
        }
        //in controller, we get the data from fields and make obj then call this function of admin
        Admin user = new Admin();
        boolean insertionCheck = user.addVendor(obj);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/add-vendors.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/add-vendors.jsp");
            view.forward(request, response);
        }
    }

}
