package com.qa.billyshakes.domain;

import javax.persistence.*;

@Entity
public class Products {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private double price;

    @Column
    private int stock;

    @Column
    private String image;

    @ManyToOne(targetEntity = Orders.class)
    private Orders orders;


    public Products() {

    }

    public Products(String title, String image, String description, double price, int stock) {
        this.title = title;
        this.image = image;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
