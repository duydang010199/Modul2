package com.example.computer_managerment.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Product {
    protected int idProduct;
    protected String title;
    protected String image;
    protected double price;
    protected int quantity;
    private String description;
    private int idCategory;

    public Product(){}

    public Product(int idProduct, String title, String image, double price, int quantity, String description, int idCategory) {
        this.idProduct = idProduct;
        this.title = title;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.idCategory = idCategory;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int id) {
        this.idProduct = id;
    }
    @NotEmpty(message = "Ten khong duoc de trong")
    @Length(min = 5, max = 50, message = "Ten cua ban qua ngan hoac qua dai")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    @Max(value = 10000, message = "Gia khong vuot qua 10000$")
    @Min(value = 1, message = "Gia nam trong khoang 1.000 den 10000$")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @Max(value = 1000, message = "So luong khong vuot qua 1000")
    @Min(value = 1, message = "So luong phai lon hon 1 va nho hon 1000")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
