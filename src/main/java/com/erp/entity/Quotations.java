package com.erp.entity;

import java.util.Date;

public class Quotations {
    int id;

    String vendorName;
    int material1; // material id
    String material1name;
    int quantity1;
    int price1;
    int material2;
    String material2name;
    int quantity2;
    int price2;
    int material3;
    String material3name;
    int quantity3;
    int price3;
    int isApproved;

    int total;

    Date orderDate;

    public Quotations(){}

    public Quotations(int id, int material1, int quantity1, int price1, int material2, int quantity2, int price2, int material3, int quantity3, int price3) {
        this.id = id;
        this.vendorName = null;
        this.isApproved = 0;
        this.material1name = null;
        this.material2name = null;
        this.material3name = null;
        this.orderDate = null;
        this.material1 = material1;
        this.quantity1 = quantity1;
        this.price1 = price1;
        this.material2 = material2;
        this.quantity2 = quantity2;
        this.price2 = price2;
        this.material3 = material3;
        this.quantity3 = quantity3;
        this.price3 = price3;
    }

    public Quotations(int id, String vendorName, int material1, String material1name, int quantity1, int price1, int material2, String material2name, int quantity2, int price2, int material3, String material3name, int quantity3, int price3, int isApproved, int total, Date orderDate) {
        this.id = id;
        this.vendorName = vendorName;
        this.material1 = material1;
        this.material1name = material1name;
        this.quantity1 = quantity1;
        this.price1 = price1;
        this.material2 = material2;
        this.material2name = material2name;
        this.quantity2 = quantity2;
        this.price2 = price2;
        this.material3 = material3;
        this.material3name = material3name;
        this.quantity3 = quantity3;
        this.price3 = price3;
        this.isApproved = isApproved;
        this.total = total;
        this.orderDate = orderDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMaterial1(int material1) {
        this.material1 = material1;
    }

    public void setQuantity1(int quantity1) {
        this.quantity1 = quantity1;
    }

    public void setPrice1(int price1) {
        this.price1 = price1;
    }

    public void setMaterial2(int material2) {
        this.material2 = material2;
    }

    public void setQuantity2(int quantity2) {
        this.quantity2 = quantity2;
    }

    public void setPrice2(int price2) {
        this.price2 = price2;
    }

    public void setMaterial3(int material3) {
        this.material3 = material3;
    }

    public void setQuantity3(int quantity3) {
        this.quantity3 = quantity3;
    }

    public void setPrice3(int price3) {
        this.price3 = price3;
    }


    public void setApproved(int approved) {
        isApproved = approved;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getMaterial1name() {
        return material1name;
    }

    public void setMaterial1name(String material1name) {
        this.material1name = material1name;
    }

    public String getMaterial2name() {
        return material2name;
    }

    public void setMaterial2name(String material2name) {
        this.material2name = material2name;
    }

    public String getMaterial3name() {
        return material3name;
    }

    public void setMaterial3name(String material3name) {
        this.material3name = material3name;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getId() {
        return id;
    }

    public int getMaterial1() {
        return material1;
    }

    public int getQuantity1() {
        return quantity1;
    }

    public int getPrice1() {
        return price1;
    }

    public int getMaterial2() {
        return material2;
    }

    public int getQuantity2() {
        return quantity2;
    }

    public int getPrice2() {
        return price2;
    }

    public int getMaterial3() {
        return material3;
    }

    public int getQuantity3() {
        return quantity3;
    }

    public int getPrice3() {
        return price3;
    }

    public int isApproved() {
        return isApproved;
    }
}

