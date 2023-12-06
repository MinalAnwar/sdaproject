package com.erp.control;

import com.erp.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "MakeProfileControl", value = "/makeprofile")
public class MakeProfileControl extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String designation = request.getParameter("designation");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String email = request.getParameter("email");
        String phoneNumber= request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String cnic = request.getParameter("cnic");
        int age = Integer.parseInt(request.getParameter("age"));
        User obj = new User();
        boolean insertionCheck = obj.updateProfile(id,name,designation,dateOfBirth,email,phoneNumber,address,cnic,age);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/profile.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/profile.jsp");
            view.forward(request, response);
        }


    }

}
