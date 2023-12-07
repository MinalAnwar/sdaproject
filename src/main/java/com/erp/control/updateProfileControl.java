package com.erp.control;

import com.erp.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "updateProfileControl", value = "/updateProfile")
public class updateProfileControl extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session= request.getSession();
        User user= (User)session.getAttribute("user");
        String designation = request.getParameter("designation");
        if(designation==null)
        {
            designation = (String) session.getAttribute("designation");
        }
        session.removeAttribute("designation");
        int id = user.getUserId();
        System.out.println(id);
        String name = request.getParameter("name");;
        String dateOfBirth = request.getParameter("dateOfBirth");
        String email = request.getParameter("email");
        String phoneNumber= request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String cnic = request.getParameter("cnic");
        int age = Integer.parseInt(request.getParameter("age"));
        final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        final String cnicRegex = "^\\d{5}-\\d{7}-\\d{1}$";
        final String phoneRegex = "^\\d{4}-\\d{7}$";

        final Pattern phonePattern = Pattern.compile(phoneRegex);
        Matcher phoneMatcher = phonePattern.matcher(request.getParameter("phoneNumber"));

        final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
        Matcher emailMatcher = emailPattern.matcher(request.getParameter("email"));

        final Pattern cnicPattern = Pattern.compile(cnicRegex);
        Matcher cnicMatcher = cnicPattern.matcher(request.getParameter("cnic"));

        if(!emailMatcher.matches() || !cnicMatcher.matches()|| !phoneMatcher.matches())
        {
            request.setAttribute("valid", false);
            RequestDispatcher view = request.getRequestDispatcher("/profile.jsp");
            view.forward(request, response);
            return;
        }
        User obj = new User();
        boolean insertionCheck = obj.updateProfile(id,name,designation,dateOfBirth,email,phoneNumber,address,cnic,age);
        if (insertionCheck) {
            user.setName(name);
            user.setDesignation(designation);
            user.setDateOfBirth(dateOfBirth);
            user.setEmail(email);
            user.setPhoneNumber(phoneNumber);
            user.setAddress(address);
            user.setCnic(cnic);
            user.setAge(age);
            session.setAttribute("designation",user.getDesignation());
            response.sendRedirect(request.getContextPath() + "/profile.jsp");
        }
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/profile.jsp");
            view.forward(request, response);
        }


    }
}
