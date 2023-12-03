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

@WebServlet(name = "vendorUpdateControl", value = "/vendorupdate")
public class vendorUpdateControl extends HttpServlet {
    //url: 'vendorupdate?vendorId=' + inputValues[0] + '&vendorName=' + inputValues[1] + '&vendorRating=' + inputValues[2] + '&vendorPhoneNumber=' + inputValues[3] + '&vendorEmail=' + inputValues[4]+ '&oldID=' + arr[0],

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Vendor obj = new Vendor(
                Integer.parseInt(request.getParameter("vendorId")),
                request.getParameter("vendorName"),
                Integer.parseInt(request.getParameter("vendorRating")),
                request.getParameter("vendorPhoneNumber"),
                request.getParameter("vendorEmail")
        );

        final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        final Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(request.getParameter("vendorEmail"));

        if(Integer.parseInt(request.getParameter("vendorId"))<0||Integer.parseInt(request.getParameter("vendorRating"))<0|| !matcher.matches())
        {
            request.setAttribute("valid", false);
            RequestDispatcher view = request.getRequestDispatcher("/all-vendors.jsp");
            view.forward(request, response);
            return;
        }
        Admin user = new Admin();
        boolean insertionCheck = user.updateVendor(Integer.parseInt(request.getParameter("oldID")),obj);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/all-vendors.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/all-vendors.jsp");
            view.forward(request, response);
        }

    }


}
