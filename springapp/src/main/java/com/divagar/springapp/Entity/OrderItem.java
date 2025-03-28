package com.divagar.springapp.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "OrderItem")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int orderItemID;
	public int quantity;
	public double subtotal;

	public int getOrderItemID() {
		return orderItemID;
	}
	public void setOrderItemID(int orderItemID) {
		this.orderItemID = orderItemID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public OrderItem(int orderItemID, int quantity, double subtotal) {
		this.orderItemID = orderItemID;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}
	public OrderItem() {
	}

	
}
