package com.erp.control;

import com.erp.entity.Admin;
import com.erp.entity.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "addOrderControl", value = "/addOrder")
public class addOrderControl extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Order obj = new Order(
                request.getParameter("orderNumber"),
                Integer.parseInt(request.getParameter("totalAmount")),
                request.getParameter("items"),
                request.getParameter("date"),
                Integer.parseInt(request.getParameter("totalItems")),
                request.getParameter("orderStatus")
        );
        final String orderIdRegx = "^\\d{3}-\\d{5}-\\d{1}$";
        final Pattern orderPattern = Pattern.compile(orderIdRegx);
        Matcher orderMatcher = orderPattern.matcher(request.getParameter("orderNumber"));
        if(Integer.parseInt(request.getParameter("totalAmount"))<0||Integer.parseInt(request.getParameter("totalItems"))<0||!orderMatcher.matches())
        {
            request.setAttribute("valid", false);
            RequestDispatcher view = request.getRequestDispatcher("/add-order.jsp");
            view.forward(request, response);
            return;
        }
        //in controller, we get the data from fields and make obj then call this function of admin
        Admin user = new Admin();
        boolean insertionCheck = user.addOrder(obj);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/add-order.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("//add-order.jsp");
            view.forward(request, response);
        }
    }
}
