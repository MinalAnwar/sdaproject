package com.erp.entity;

public class RawMaterial {
    private int productId;
    private String name;
    private Double price;
    private int totalQuantity;

    public RawMaterial(){}
    public RawMaterial(int productId, String name, Double price, int totalQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.totalQuantity = totalQuantity;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void calculateTotalValue()
    {
        //call dao function take all product with price from database
        // then for each product take sum and get total value
    }
}
