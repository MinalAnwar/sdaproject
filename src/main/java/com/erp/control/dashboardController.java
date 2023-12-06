package com.erp.control;

import com.erp.dao.SystemWorks;

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
        System.out.println(graphStats.get("Orders"));
        resp.sendRedirect("dashboard.jsp");
    }
}