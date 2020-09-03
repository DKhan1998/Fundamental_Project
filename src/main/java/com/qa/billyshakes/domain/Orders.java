package com.qa.billyshakes.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "notes"})
public class Orders {

    @Id
    @GeneratedValue
    private Long orderId;

    @OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    private List<Products> products = new ArrayList<>();

    @Column
    @GeneratedValue
    private String orderDate;

    @Column
    private String status;

    @Column
    private int quantity;

    @Column
    private double overallPrice;

    public Orders() {

    }

    public Orders(List<Products> products, String orderDate, String status, int quantity, double overallPrice) {
        this.products = products;
        this.orderDate = orderDate;
        this.status = status;
        this.quantity = quantity;
        this.overallPrice = overallPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getOverallPrice() {
        return overallPrice;
    }

    public void setOverallPrice(double overallPrice) {
        this.overallPrice = overallPrice;
    }

    public List<Products> getProducts(){
        return products;
    }

    public void setProducts(List<Products> products){
        this.products = products;
    }
}
