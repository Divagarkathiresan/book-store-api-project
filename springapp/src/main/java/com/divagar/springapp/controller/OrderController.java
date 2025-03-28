package com.divagar.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.divagar.springapp.Entity.ordertable;
import com.divagar.springapp.Entity.Book;
import com.divagar.springapp.service.orderTableService;
import com.divagar.springapp.service.BookService;

@RestController
@RequestMapping("/orders") // Base URL for all order-related endpoints
public class OrderController {
    
    @Autowired
    private orderTableService orderService;
    
    @Autowired
    private BookService bookService;

    // Create a new order and associate it with a book
    @PostMapping("/add/{bookId}")
    public ResponseEntity<?> addNewOrder(@PathVariable int bookId, @RequestBody ordertable order) {
        Optional<Book> book = bookService.getBookById(bookId);
        if (book.isPresent()) {
            order.setBook(book.get()); // Associate order with the book
            ordertable savedOrder = orderService.addNewOrder(bookId, order);
            return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID " + bookId + " not found.");
        }
    }

    // Get all orders
    @GetMapping
    public ResponseEntity<List<ordertable>> getAllOrders() {
        List<ordertable> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    // Get a single order by ID
    @GetMapping("/{id}")
public ResponseEntity<ordertable> getSingleOrder(@PathVariable int id) {
    return orderService.getSingleOrder(id)
            .map(order -> new ResponseEntity<>(order, HttpStatus.OK))
            .orElseThrow(() -> new RuntimeException("Order with ID " + id + " not found"));
}


    // Update an existing order
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateSingleOrder(@PathVariable int id, @RequestBody ordertable updatedOrder) {
        Optional<ordertable> existingOrder = orderService.getSingleOrder(id);
        if (existingOrder.isPresent()) {
            ordertable updated = orderService.updateSingleOrder(id, updatedOrder);
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order ID " + id + " not found.");
        }
    }

    // Delete an order by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSingleOrder(@PathVariable int id) {
        Optional<ordertable> order = orderService.getSingleOrder(id);
        if (order.isPresent()) {
            orderService.deleteSingleOrder(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Order ID " + id + " deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order ID " + id + " not found.");
        }
    }

    // Get sorted orders by field (e.g., orderDate, totalAmount, status)
    @GetMapping("/sort/{field}")
    public ResponseEntity<List<ordertable>> getSortedOrder(@PathVariable String field) {
        return new ResponseEntity<>(orderService.getSortedOrder(field), HttpStatus.OK);
    }

    // Pagination for orders
    @GetMapping("/page/{pageNumber}/{pageSize}")
    public ResponseEntity<List<ordertable>> getPaginatedOrders(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return new ResponseEntity<>(orderService.getPaginatedOrders(pageNumber, pageSize), HttpStatus.OK);
    }
}
