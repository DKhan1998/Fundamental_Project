package com.qa.billyshakes.dto;

import javax.persistence.Column;

public class ProductsDTO {

    private Long id;
    private String title;
    private String description;
    private int price;
    private int stock;

    public ProductsDTO() {

    }

    public ProductsDTO(String title, int price, int stock, String description) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
