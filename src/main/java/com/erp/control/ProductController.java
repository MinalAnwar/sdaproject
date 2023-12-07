package com.erp.control;

import com.erp.dao.InventoryDao;
import com.erp.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductController", value = "/add-product")
public class ProductController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get a List of vendor from DB
        InventoryDao getProduct = new InventoryDao();
        List<Product> products =getProduct.getAllProduct();
        req.setAttribute("product", products);

        req.getRequestDispatcher("add-product.jsp").forward(req, resp);

    }
}
