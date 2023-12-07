package com.erp.control;

import com.erp.dao.InventoryDao;
import com.erp.dao.SystemWorks;
import com.erp.dao.VendorDao;
import com.erp.entity.RawMaterial;
import com.erp.entity.Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "dashboardController", value = "/dashboard")
public class dashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SystemWorks system = new SystemWorks();
        Map<String, Object> info = new HashMap<>();
        info = system.getDashboardInfo();
        HttpSession session = req.getSession();
        session.setAttribute("dashboardInfo", info);

        // Linear Regression stuff
        Map<String, List<Integer>> graphStats = system.getStatistiks();
        int estimatedOrders = system.LinearRegression(graphStats.get("Years"), graphStats.get("Orders"), 2024);

        int estimatedProfit = system.LinearRegression(graphStats.get("Orders"), graphStats.get("Profit"), estimatedOrders);
        session.setAttribute("estimatedOrder", estimatedOrders);
        session.setAttribute("estimatedProfit", estimatedProfit);
        session.setAttribute("graphStats", graphStats);

        // Get a List of vendor from DB to load all material in session in first page
            InventoryDao getRawMaterial = new InventoryDao();
            List<RawMaterial> materials =getRawMaterial.getAllRawMaterial();
            session.setAttribute("material", materials);

            VendorDao vendorDao = new VendorDao();
            List<Vendor> vendors = vendorDao.getAllVendors();
            session.setAttribute("vendors", vendors);


        Map<String, List<Integer>> requirement = system.getRequirements();
        int estimatedItems = system.LinearRegression(requirement.get("Years"), requirement.get("quantity"), 2024.0);
        session.setAttribute("estimatedItems", estimatedItems);
        resp.sendRedirect("dashboard.jsp");

    }
}