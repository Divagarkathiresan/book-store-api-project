package com.divagar.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.divagar.springapp.Entity.OrderItem;
import com.divagar.springapp.service.OrderItemService;

@RestController
@RequestMapping("/api/orderItem")
public class OrderItemController {

	@Autowired
	OrderItemService orderitemService;

	@PostMapping
	public ResponseEntity<OrderItem> createNewOrderItem(@RequestBody OrderItem orderitem)
	{
		return new ResponseEntity<>(orderitemService.createNewOrderItem(orderitem),HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<OrderItem>> getAllOrderItems()
	{
		return new ResponseEntity<>(orderitemService.getAllOrderItems(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<OrderItem>> getSingleOrderItem(@PathVariable int id)
	{
		return new ResponseEntity<>(orderitemService.getSingleOrderItem(id),HttpStatus.FOUND);
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrderItem> updateSingleOrderItem(@PathVariable int id,@RequestBody OrderItem order)
	{
		Optional<OrderItem> orderitem = orderitemService.getSingleOrderItem(id);
		if(orderitem.isPresent())
		{
			return new ResponseEntity<>(orderitemService.updateSingleOrderItem(id, order),HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<OrderItem> DeleteSingleOrderItem(@PathVariable int id)
	{
		Optional<OrderItem> orderitem = orderitemService.getSingleOrderItem(id);
		if(orderitem.isPresent())
		{
			orderitemService.DeleteSingleOrderItem(id);
			return new ResponseEntity<>(orderitem.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}

	}
}
