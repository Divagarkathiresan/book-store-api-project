package com.divagar.springapp.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.divagar.springapp.Entity.ordertable;
import com.divagar.springapp.service.orderTableService;

@RestController
public class OrderController {
	@Autowired
    orderTableService obj2;
    @PostMapping("/POST/orders")
    public ResponseEntity<ordertable> AddNewOrder(@RequestBody ordertable o)
    {
        return new ResponseEntity<>(obj2.AddNewOrder(o),HttpStatus.OK);
    }@GetMapping("/GET/orders")
    public ResponseEntity<List<ordertable>> GetAllOrders()
    {
        return new ResponseEntity<>(obj2.GetAllOrders(),HttpStatus.OK);
    }@GetMapping("/GET/orders/{id}")
    public ResponseEntity<ordertable> GetSingleOrder(@PathVariable int id)
    {Optional<ordertable> order = obj2.GetSingleOrder(id);
        if(order.isPresent())
        {
            return new ResponseEntity<>(order.get(),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }@PutMapping("/PUT/orders/{id}")
    public ResponseEntity<ordertable> UpdateSingleOrder(@PathVariable int id,@RequestBody ordertable neworder)
    {Optional<ordertable> order = obj2.GetSingleOrder(id);
        if(order.isPresent())
        {
            return new ResponseEntity<>(obj2.UpdateSingleOrder(id,neworder),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }@DeleteMapping("/DELETE/orders/{id}")
    public ResponseEntity<ordertable> DeleteSingleOrder(@PathVariable int id)
    {Optional<ordertable> order = obj2.GetSingleOrder(id);
        if(order.isPresent())
        {
            obj2.DeleteSingleOrder(id);
            return new ResponseEntity<>(order.get(),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/SORT/orders/{field}")
    public ResponseEntity<List<ordertable>> GetSortedOrder(@PathVariable String field)
    {
        return new ResponseEntity<>(obj2.GetSortedOrder(field),HttpStatus.OK);
    } 

	@GetMapping("/PAGE/orders/{pagenumber}/{pagesize}")
    public ResponseEntity<List<ordertable>> Pagination(@PathVariable int pagenumber , @PathVariable int pagesize)
    {
        return new ResponseEntity<>(obj2.Pagination(pagenumber,pagesize),HttpStatus.OK);
    }
}
