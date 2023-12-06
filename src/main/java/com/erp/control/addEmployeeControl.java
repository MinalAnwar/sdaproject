package com.erp.control;


import com.erp.entity.Admin;
import com.erp.entity.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "addEmployeeControl", value = "/addEmployee")
public class addEmployeeControl extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            Employee obj = new Employee(
                    request.getParameter("name"),
                    1,
                    request.getParameter("designation"),
                    request.getParameter("address"),
                    request.getParameter("email"),
                    request.getParameter("phoneNumber"),
                    Integer.parseInt(request.getParameter("age")),
                    request.getParameter("dateOfBirth"),
                    request.getParameter("cnic"),
                    request.getParameter("gender"),
                    request.getParameter("joiningDate"),
                    Integer.parseInt(request.getParameter("salary"))
            );
            final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            final String cnicRegex = "^\\d{5}-\\d{7}-\\d{1}$";
            final String phoneRegex = "^\\d{4}-\\d{7}$";

            final Pattern phonePattern = Pattern.compile(phoneRegex);
            Matcher phoneMatcher = phonePattern.matcher(request.getParameter("phoneNumber"));

        final Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
            Matcher emailMatcher = emailPattern.matcher(request.getParameter("email"));

            final Pattern cnicPattern = Pattern.compile(cnicRegex);
            Matcher cnicMatcher = cnicPattern.matcher(request.getParameter("cnic"));

        if(Integer.parseInt(request.getParameter("salary"))<0||Integer.parseInt(request.getParameter("age"))<0 || !emailMatcher.matches() || !cnicMatcher.matches()|| !phoneMatcher.matches())
            {
                request.setAttribute("valid", false);
                RequestDispatcher view = request.getRequestDispatcher("/add-employee.jsp");
                view.forward(request, response);
                return;
            }
        //in controller, we get the data from fields and make obj then call this function of admin
        Admin user = new Admin();
        boolean insertionCheck = user.addEmplyee(obj);
        if (insertionCheck)
            response.sendRedirect(request.getContextPath() + "/add-employee.jsp");
        else {
            request.setAttribute("valid", insertionCheck);
            RequestDispatcher view = request.getRequestDispatcher("/add-employee.jsp");
            view.forward(request, response);
        }
    }
}
