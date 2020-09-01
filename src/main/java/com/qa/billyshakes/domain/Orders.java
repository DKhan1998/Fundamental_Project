package com.qa.billyshakes.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "notes"})
public class Orders {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    private List<Products> products = new ArrayList<>();

    @Column
    @GeneratedValue
    private String orderDate;

    @Column
    private String status;

//    @Column
//    private int quantity;

//    @Column
//    private double overallPrice;

    public Orders() {

    }

    public Orders(String orderDate, String status) {
        this.orderDate = orderDate;
        this.status = status;
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

    public List<Products> getProducts(){
        return products;
    }

    public void setProducts(List<Products> products){
        this.products = products;
    }
}
