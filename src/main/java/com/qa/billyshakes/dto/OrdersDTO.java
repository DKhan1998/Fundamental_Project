package com.qa.billyshakes.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersDTO {

    private Long orderId;
    private String date;
    private List<ProductsDTO> products = new ArrayList<>();
    private String Status;

    public OrdersDTO() {
    }

    public OrdersDTO(String date, List<ProductsDTO> products, String status) {
        super();
        this.date = date;
        this.products = products;
        Status = status;
    }

    public Long getId() {
        return orderId;
    }

    public void setId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<ProductsDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsDTO> products) {
        this.products = products;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
