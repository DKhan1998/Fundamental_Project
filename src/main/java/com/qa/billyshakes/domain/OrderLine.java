package com.qa.billyshakes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class OrderLine {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Long order_ID;

    @Column
    private Long product_ID;

    @Column
    private int quantity;

    public OrderLine() {
    }

    public OrderLine(Long order_ID, Long product_ID, int quantity) {
        this.order_ID = order_ID;
        this.product_ID = product_ID;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(Long order_ID) {
        this.order_ID = order_ID;
    }

    public Long getProduct_ID() {
        return product_ID;
    }

    public void setProduct_ID(Long product_ID) {
        this.product_ID = product_ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
