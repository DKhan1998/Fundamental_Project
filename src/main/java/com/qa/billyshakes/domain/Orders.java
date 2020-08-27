package com.qa.billyshakes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    private String id;

    @Column
    private String fk_userID;

    @Column
    @GeneratedValue
    private Date orderDate;

    @Column
    private String status;

    public Orders(String fk_userID, Date orderDate, String status) {
        this.fk_userID = fk_userID;
        this.orderDate = orderDate;
        this.status = status;
    }

    public String getFk_userID() {
        return fk_userID;
    }

    public void setFk_userID(String fk_userID) {
        this.fk_userID = fk_userID;
    }

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

    public Orders() {

    }
}
