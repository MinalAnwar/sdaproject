package com.erp.entity;

public class Quotations {
    int id;
    int material1; // material id
    int quantity1;
    int price1;
    int material2;
    int quantity2;
    int price2;
    int material3;
    int quantity3;
    int price3;
    boolean isApproved;

    public Quotations(){}

    public Quotations(int id, int material1, int quantity1, int price1, int material2, int quantity2, int price2, int material3, int quantity3, int price3) {
        this.id = id;
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


    public void setApproved(boolean approved) {
        isApproved = approved;
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

    public boolean isApproved() {
        return isApproved;
    }
}

