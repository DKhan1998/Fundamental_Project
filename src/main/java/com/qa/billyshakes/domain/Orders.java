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

//    @Column
//    private String fk_userID;

    @OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    private List<Products> products = new ArrayList<>();

    @Column
    @GeneratedValue
    private Date orderDate;

    @Column
    private String status;

    public Orders() {

    }

    public Orders(String fk_userID, Date orderDate, String status) {
//        this.fk_userID = fk_userID;
        this.orderDate = orderDate;
        this.status = status;
    }

//    public String getFk_userID() {
//        return fk_userID;
//    }
//
//    public void setFk_userID(String fk_userID) {
//        this.fk_userID = fk_userID;
//    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
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
