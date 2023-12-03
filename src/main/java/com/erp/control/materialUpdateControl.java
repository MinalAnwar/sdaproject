package com.erp.control;

import com.erp.entity.Admin;
import com.erp.entity.Inventory;
import com.erp.entity.RawMaterial;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "materialUpdateControl", value = "/materialUpdate")
public class materialUpdateControl extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("inside controller");
        HttpSession session = request.getSession();
        Inventory inventory = (Inventory) session.getAttribute("inventory");

        // If the inventory object doesn't exist in the session, create a new one
        if (inventory == null) {
            inventory = new Inventory();
            session.setAttribute("inventory", inventory);
        }
        RawMaterial rawMaterial = new RawMaterial(
                Integer.parseInt(request.getParameter("materialId")),
                request.getParameter("materialName"),
                Double.parseDouble(request.getParameter("materialPrice")),
                Integer.parseInt(request.getParameter("materialQuantity"))
        );
        inventory.addRawMaterial(rawMaterial);
        if(Integer.parseInt(request.getParameter("materialId"))<0||Integer.parseInt(request.getParameter("materialPrice"))<0||Integer.parseInt(request.getParameter("materialQuantity"))<0)
        {
            request.setAttribute("valid", false);
            RequestDispatcher view = request.getRequestDispatcher("/all-materials.jsp");
            view.forward(request, response);
            return;
        }
        Admin user = new Admin();
        String status ="rawmaterial";
        boolean insertionCheck = user.updateInventory(Integer.parseInt(request.getParameter("oldID")),inventory,status);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/all-materials.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/all-materials.jsp");
            view.forward(request, response);
        }
    }
}

