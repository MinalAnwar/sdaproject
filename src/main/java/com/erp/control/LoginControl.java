package com.erp.control;

import com.erp.dao.AccountDao;
import com.erp.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name = "LoginControl", value = "/login")