package com.erp.control;

import com.erp.dao.QuotationDao;
import com.erp.entity.Quotations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "quotationController", value = "/quotation")
public class quotationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuotationDao quotationDao = new QuotationDao();

        if(req.getParameter("id") != null) {
            Integer deleted_id = Integer.parseInt(req.getParameter("id"));
            if (deleted_id != null) {
                quotationDao.deleteByID(deleted_id);
                resp.sendRedirect("quotation");
            }
        }
        else {
            // get all quotations from the db
            List<Quotations> quotations;
            quotations = quotationDao.getAllQuotations();
            HttpSession session = req.getSession();
            session.setAttribute("quotations", quotations);
            resp.sendRedirect("all-quotation.jsp");
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QuotationDao quotationDao = new QuotationDao();

        int id = Integer.parseInt(req.getParameter("id"));
        int p1id = Integer.parseInt(req.getParameter("p1id"));
        int p2id = Integer.parseInt(req.getParameter("p2id"));
        int p3id = Integer.parseInt(req.getParameter("p3id"));
        int quantity1 = Integer.parseInt(req.getParameter("p1quantity"));
        int quantity2 = Integer.parseInt(req.getParameter("p2quantity"));
        int quantity3 = Integer.parseInt(req.getParameter("p3quantity"));
        int totalPrice = Integer.parseInt(req.getParameter("totalPrice"));
        int totalQuantity = Integer.parseInt(req.getParameter("totalQuantity"));

        quotationDao.addQuantities(p1id, p2id, p3id, quantity1, quantity2, quantity3);
        quotationDao.placeMaterialOrder(id, totalQuantity, totalPrice);

        resp.sendRedirect("quotation");

    }
}
