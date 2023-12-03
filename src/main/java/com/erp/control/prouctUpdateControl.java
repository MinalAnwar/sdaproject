package com.erp.control;


import com.erp.entity.Admin;
import com.erp.entity.Inventory;
import com.erp.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "prouctUpdateControl", value = "/productUpdate")
public class prouctUpdateControl extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Inventory inventory = (Inventory) session.getAttribute("inventory");

        // If the inventory object doesn't exist in the session, create a new one
        if (inventory == null) {
            inventory = new Inventory();
            session.setAttribute("inventory", inventory);
        }
        Product product=new Product(
                Integer.parseInt(request.getParameter("productId")),
                request.getParameter("productName"),
                Double.parseDouble(request.getParameter("productPrice")),
                Integer.parseInt(request.getParameter("productQuantity"))
        );

        inventory.addProduct(product);
        if(Integer.parseInt(request.getParameter("productId"))<0||Integer.parseInt(request.getParameter("productPrice"))<0||Integer.parseInt(request.getParameter("productQuantity"))<0)
        {
            request.setAttribute("valid", false);
            RequestDispatcher view = request.getRequestDispatcher("/all-products.jsp");
            view.forward(request, response);
            return;
        }
        Admin user = new Admin();
        String status ="product";
        boolean insertionCheck = user.updateInventory(Integer.parseInt(request.getParameter("oldID")),inventory,status);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/all-products.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/all-products.jsp");
            view.forward(request, response);
        }
    }
}
