<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<div class="main-wrapper">
    <div class="header">
        <div class="header-left">
            <b><a href="dashboard.jsp" class="logo"> <span class="logoclass">ERP</span> </a></b>
            <b><a href="dashboard.jsp" class="logo logo-small" style="font-size: large; color:#009688;">ERP</a></b>
        </div>
        <a href="javascript:void(0);" id="toggle_btn"> <i class="fe fe-text-align-left"></i> </a>
        <a class="mobile_btn" id="mobile_btn"> <i class="fas fa-bars"></i> </a>
        <ul class="nav user-menu">

            <li class="nav-item dropdown has-arrow">
                <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown"> <span class="user-img"><i class="fa-solid fa-bars"></i></span> </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="profile.jsp">My Profile</a><a class="dropdown-item" href="index.jsp">Logout</a></div>
            </li>
        </ul>

    </div>
    <div class="sidebar" id="sidebar">
        <div class="sidebar-inner slimscroll">
            <div id="sidebar-menu" class="sidebar-menu">
                <ul>
                    <li class="active"> <a href="dashboard.jsp"><i class="fas fa-tachometer-alt"></i> <span>Dashboard</span></a> </li>
                    <li class="list-divider"></li>

                        <c:if test = "${desigantion==null}">
                            <li class="submenu"> <a href="#"><i class="fas fa-user"></i> <span>Complete Profile</span> <span class="menu-arrow"></span></a>
                                <ul class="submenu_class" style="display: none;">
                                    <li><a href="profile.jsp"> Profile </a></li>
                                </ul>
                            </li>
                        </c:if>
                        <c:choose>


                            <c:when test="${designation.equalsIgnoreCase('Admin')}">
                            <li class="submenu"> <a href="#"><i class="fas fa-user"></i> <span>Employee</span> <span class="menu-arrow"></span></a>
                        <ul class="submenu_class" style="display: none;">
                            <li><a href="all-employee.jsp"> All Employees </a></li>
                            <li><a href="add-employee.jsp"> Add Employee </a></li>

                        </ul>
                    </li>
                    </c:when>
                    </c:choose>

                    <c:choose>
                    <c:when test="${designation.equalsIgnoreCase('Admin')||designation.equalsIgnoreCase('Manager')}">
                    <li class="submenu"> <a href="#"><i class="fa-solid fa-bars"></i></fa-solid><span>Products</span> <span class="menu-arrow"></span></a>
                        <ul class="submenu_class" style="display: none;">
                            <li><a href="all-products.jsp">All Products </a></li>
                            <li><a href="add-product.jsp"> Add Product </a></li>
                        </ul>
                    </li>
                    </c:when>
                    </c:choose>

                    <c:choose>
                    <c:when test="${designation.equalsIgnoreCase('Admin')||designation.equalsIgnoreCase('Manager')}">
                    <li class="submenu"> <a href="#"><i class="fas fa-suitcase"></i> <span>Materials</span> <span class="menu-arrow"></span></a>
                        <ul class="submenu_class" style="display: none;">
                            <li><a href="all-materials.jsp"> All Materials </a></li>
                            <li><a href="add-material.jsp"> Add Material </a></li>

                        </ul>
                    </li>
                    </c:when>
                    </c:choose>

                    <c:choose>
                    <c:when test="${designation.equalsIgnoreCase('Admin')||designation.equalsIgnoreCase('Manager')}">
                    <li class="submenu"> <a href="#"><i class="fa-solid fa-clipboard-list"></i><span>Companay's Order</span> <span class="menu-arrow"></span></a>
                        <ul class="submenu_class" style="display: none;">
                            <li><a href="all-orders.jsp">All Orders </a></li>
                            <li><a href="add-order.jsp"> Add Order </a></li>
                        </ul>
                    </li>
                    </c:when>
                    </c:choose>

                    <c:choose>
                        <c:when test="${designation.equalsIgnoreCase('Admin')}">
                            <li class="submenu"> <a href="#"><i class="fa fa-industry"></i> <span>Quotations</span> <span class="menu-arrow"></span></a>
                                <ul class="submenu_class" style="display: none;">
                                    <li><a href="add-quotation"> Add Quotations </a></li>
                                    <li><a href="all-quotation.jsp"> All Quotations </a></li>

                                </ul>
                            </li>
                        </c:when>
                    </c:choose>

                    <c:choose>
                    <c:when test="${designation.equalsIgnoreCase('Manager')}">
                        <li class="submenu"> <a href="#"><i class="fa fa-industry"></i> <span>Quotations</span> <span class="menu-arrow"></span></a>
                            <ul class="submenu_class" style="display: none;">
                                <li><a href="add-quotation.html"> Add Quotations </a></li>
                            </ul>
                        </li>
                    </c:when>
                    </c:choose>

                    <c:choose>
                        <c:when test="${designation.equalsIgnoreCase('Admin')||designation.equalsIgnoreCase('Manager')}">
                        <li class="submenu"> <a href="#"><i class="fa fa-industry"></i> <span>Vendors</span> <span class="menu-arrow"></span></a>
                        <ul class="submenu_class" style="display: none;">
                            <li><a href="all-vendors.jsp"> All Vendors </a></li>
                            <li><a href="add-vendors.jsp"> Add Vendors </a></li>

                        </ul>
                    </li>
                    </c:when>
                    </c:choose>


                    <c:choose>
                    <c:when test="${designation.equalsIgnoreCase('Admin')}">
                    <li class="submenu"> <a href="#"><i class="fa fa-industry"></i> <span>Tasks</span> <span class="menu-arrow"></span></a>
                        <ul class="submenu_class" style="display: none;">
                            <li><a href="all-tasks.jsp"> All Tasks </a></li>
                            <li><a href="add-task.jsp"> Add Task </a></li>
                            <li><a href="allAssigned-tasks.jsp"> All Assigned Tasks </a></li>
                            <li><a href="assign-task.jsp"> Assign Task </a></li>

                        </ul>
                    </li>
                    </c:when>
                </c:choose>
<%--                    jstl that tells weather it will be visible or not on basis of designation--%>
                    <c:choose>
                        <c:when test="${designation.equalsIgnoreCase('Quality anaylist')||designation.equalsIgnoreCase('Admin')}">
                        <li class="submenu"> <a href="#"><i class="fa-solid fa-star"></i><span>Quality</span> <span class="menu-arrow"></span></a>
                            <ul class="submenu_class" style="display: none;">
                                <li><a href="report.html">Quality Report</a></li>
                                <li><a href="rate-product.html">Rate product</a></li>
                            </ul>
                        </li>
                        </c:when>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>