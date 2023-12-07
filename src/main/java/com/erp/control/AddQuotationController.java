package com.erp.control;

import com.erp.entity.Manager;
import com.erp.entity.Quotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddQuotationController", value = "/addQuotation")
public class AddQuotationController extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        boolean insertionCheck = false;
        String email = request.getParameter("vendor");
        int matrial2 =Integer.parseInt(request.getParameter("material2"));
        int material3 = Integer.parseInt(request.getParameter("material3"));
        Manager user = new Manager();
        if(matrial2==-1)
        {
            Quotations obj = new Quotations(1,
                    Integer.parseInt(request.getParameter("material1")),
                    Integer.parseInt(request.getParameter("quantity1")),
                    Integer.parseInt(request.getParameter("price1")),
                    0, 0, 0,
                    Integer.parseInt(request.getParameter("material3")),
                    Integer.parseInt(request.getParameter("quantity3")),
                    Integer.parseInt(request.getParameter("price3"))
            );
            insertionCheck = user.addQuotation(email,obj);


        }
        else if(material3==-1)
        {
            Quotations obj = new Quotations(1,
                    Integer.parseInt(request.getParameter("material1")),
                    Integer.parseInt(request.getParameter("quantity1")),
                    Integer.parseInt(request.getParameter("price1")),
                    Integer.parseInt(request.getParameter("material2")),
                    Integer.parseInt(request.getParameter("quantity2")),
                    Integer.parseInt(request.getParameter("price2")),
                    0, 0, 0
            );
            insertionCheck = user.addQuotation(email,obj);

        }
        else if(material3 == -1 && matrial2 ==-1)
        {
            Quotations obj = new Quotations(1,
                    Integer.parseInt(request.getParameter("material1")),
                    Integer.parseInt(request.getParameter("quantity1")),
                    Integer.parseInt(request.getParameter("price1")),
                    0, 0, 0, 0, 0, 0
            );
            insertionCheck = user.addQuotation(email,obj);

        }
        else {
            Quotations obj = new Quotations(1,
                    Integer.parseInt(request.getParameter("material1")),
                    Integer.parseInt(request.getParameter("quantity1")),
                    Integer.parseInt(request.getParameter("price1")),
                    Integer.parseInt(request.getParameter("material2")),
                    Integer.parseInt(request.getParameter("quantity2")),
                    Integer.parseInt(request.getParameter("price2")),
                    Integer.parseInt(request.getParameter("material3")),
                    Integer.parseInt(request.getParameter("quantity3")),
                    Integer.parseInt(request.getParameter("price3"))
            );
            insertionCheck = user.addQuotation(email,obj);

        }
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/add-quotation.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/add-quotation.jsp");
            view.forward(request, response);
        }

    }
}
