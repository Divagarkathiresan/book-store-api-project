package com.divagar.springapp.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "OrderItem")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int orderItemID;
	public int Quantity;
	public double subtotal;
	public int getOrderItemID() {
		return orderItemID;
	}
	public void setOrderItemID(int orderItemID) {
		this.orderItemID = orderItemID;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		this.Quantity = quantity;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public OrderItem(int orderItemID, int quantity, double subtotal) {
		this.orderItemID = orderItemID;
		this.Quantity = quantity;
		this.subtotal = subtotal;
	}
	public OrderItem() {
	}

	
}
