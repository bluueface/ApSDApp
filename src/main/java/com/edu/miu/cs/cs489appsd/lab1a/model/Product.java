package com.edu.miu.cs.cs489appsd.lab1a.model;

import java.time.LocalDate;

public class Product {
    private String productId;
    private String name;
    private LocalDate dateSupplied;
    private int quantityInStock;
    private double unitPrice;

    public Product() {
    }

    public Product(String productId, String name, LocalDate dateSupplied, int quantityInStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product(String productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + name +
                ", Date Supplied: " + dateSupplied +
                ", Quantity In Stock: " + quantityInStock +
                ", Unit Price: $" + unitPrice;
    }
}

