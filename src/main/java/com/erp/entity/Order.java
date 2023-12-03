package com.erp.entity;

public class Order {
    private String orderNumber;
    private int totalAmount;
    private String Items;
    private String date;
    private int totalItems;
    private String orderStatus;

    public Order(){}

    public Order(String orderNumber, int totalAmount, String items, String date, int totalItems, String orderStatus) {
        this.orderNumber = orderNumber;
        this.totalAmount = totalAmount;
        Items = items;
        this.date = date;
        this.totalItems = totalItems;
        this.orderStatus = orderStatus;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setItems(String items) {
        Items = items;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public String getItems() {
        return Items;
    }

    public String getDate() {
        return date;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public String getOrderStatus() {
        return orderStatus;
    }
}
