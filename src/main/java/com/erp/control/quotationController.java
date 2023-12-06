package com.erp.control;

import com.erp.dao.VendorDao;
import com.erp.entity.Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "quotationController", value = "/add-quotation")
public class quotationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get a List of vendors from DB
        VendorDao vendorDao = new VendorDao();
        List<Vendor> vendors = vendorDao.getAllVendors();
        req.setAttribute("vendors", vendors);

        req.getRequestDispatcher("add-quotation.jsp").forward(req, resp);

    }
}
