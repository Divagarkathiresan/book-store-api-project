package com.divagar.springapp.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "ordertable")
public class ordertable {
    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(name="orderdate")
    public String orderDate;
    @Column(name="order_totalAmount")
    public String totalAmount;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
    public ordertable(int id, String orderDate, String totalAmount) {
        this.id = id;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
    public ordertable() {
    }
    
}
