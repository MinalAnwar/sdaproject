package com.erp.entity;

public class Vendor {
    private int vendorId;
    private String name;
    private int rating;
    private String phoneNumber;
    private String email;


    public Vendor(){}
    public Vendor(int vendorId, String name, int rating, String phoneNumber, String email) {
        this.vendorId = vendorId;
        this.name = name;
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVendorId() {
        return vendorId;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void sendQuotation()
    {
        //send email function done by nouman
    }
}
