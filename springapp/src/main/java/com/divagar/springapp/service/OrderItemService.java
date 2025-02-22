package com.divagar.springapp.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divagar.springapp.Entity.OrderItem;
import com.divagar.springapp.Repository.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	OrderItemRepository objOrderItem;

	public OrderItem createNewOrderItem(OrderItem orderitem)
	{
		return objOrderItem.save(orderitem);
	}

	public List<OrderItem> getAllOrderItems()
	{
		return objOrderItem.findAll();
	}

	public Optional<OrderItem> getSingleOrderItem(int id)
	{
		return objOrderItem.findById(id);
	}

	public OrderItem updateSingleOrderItem(int id,OrderItem neworder)
	{
		return objOrderItem.findById(id)
		.map(O->
		{
			if(neworder.getQuantity() > 0)
			{
				O.setQuantity(neworder.getQuantity());
			}
			if(neworder.getSubtotal() > 0)
			{
				O.setSubtotal(neworder.getSubtotal());
			}
			return objOrderItem.save(O);
		}).orElseThrow(()-> new RuntimeException("Id not found"));
	}

	public void DeleteSingleOrderItem(int id)
	{
		if(objOrderItem.existsById(id))
		{
			objOrderItem.deleteById(id);
		}
		else
		{
			throw new RuntimeException("Id not Found");
		}
	}


}
