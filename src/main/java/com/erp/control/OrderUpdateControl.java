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

@WebServlet(name = "OrderUpdateControl", value = "/orderUpdate")
public class OrderUpdateControl extends HttpServlet {
//'orderUpdate?orderId=' + inputValues[0] + '&totalAmount=' + inputValues[1] + '&itemList=' + inputValues[2] + '&date=' + inputValues[3] + '&totalItems=' + inputValues[4]+ '&orderStatus=' + inputValues[5]+ '&oldID=' + arr[0],
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Order obj = new Order(
                request.getParameter("orderNumber"),
                Integer.parseInt(request.getParameter("totalAmount")),
                request.getParameter("itemList"),
                request.getParameter("date"),
                Integer.parseInt(request.getParameter("totalItems")),
                request.getParameter("orderStatus")
        );

        if(Integer.parseInt(request.getParameter("totalAmount"))<0||Integer.parseInt(request.getParameter("totalItems"))<0)
        {
            request.setAttribute("valid", false);
            RequestDispatcher view = request.getRequestDispatcher("/all-orders.jsp");
            view.forward(request, response);
            return;
        }
        Admin user = new Admin();
        boolean insertionCheck = user.updateOrder(request.getParameter("oldID"),obj);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/all-orders.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/all-orders.jsp");
            view.forward(request, response);
        }

    }

}
