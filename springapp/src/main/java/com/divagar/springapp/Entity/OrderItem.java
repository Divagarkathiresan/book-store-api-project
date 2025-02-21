package com.divagar.springapp.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "OrderItem")
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int orderItemID;
	public int Quantity;
	public double Subtotal;
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
		Quantity = quantity;
	}
	public double getSubtotal() {
		return Subtotal;
	}
	public void setSubtotal(double subtotal) {
		Subtotal = subtotal;
	}
	public OrderItem(int orderItemID, int quantity, double subtotal) {
		this.orderItemID = orderItemID;
		Quantity = quantity;
		Subtotal = subtotal;
	}
	public OrderItem() {
	}

	
}
