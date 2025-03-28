package com.divagar.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.divagar.springapp.Entity.ordertable;
import com.divagar.springapp.Entity.Book;
import com.divagar.springapp.Repository.OrderRepository;
import com.divagar.springapp.Repository.BookRespository;

@Service
public class orderTableService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private BookRespository bookRepository;

    // Add a new order and associate it with a book
    public ordertable addNewOrder(int bookId, ordertable order) {
        Optional<Book> book = bookRepository.findById(bookId);
        if (book.isPresent()) {
            order.setBook(book.get()); // Associate order with the book 
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Book with ID " + bookId + " not found");
        }
    }

    // Get all orders
    public List<ordertable> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get a single order by ID
    public Optional<ordertable> getSingleOrder(int id) {
        return orderRepository.findById(id);
    }

    // Update an existing order
    public ordertable updateSingleOrder(int id, ordertable updatedOrder) {
        return orderRepository.findById(id)
            .map(existingOrder -> {
                if (updatedOrder.getOrderDate() != null) {
                    existingOrder.setOrderDate(updatedOrder.getOrderDate());
                }
                if (updatedOrder.getTotalAmount() > 0) {
                    existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
                }
                return orderRepository.save(existingOrder);
            })
            .orElseThrow(() -> new RuntimeException("Order ID " + id + " not found"));
    }

    // Delete an order
    public void deleteSingleOrder(int id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new RuntimeException("Order ID " + id + " not found");
        }
    }

    // Get sorted orders by a specific field
    public List<ordertable> getSortedOrder(String field) {
        Sort sort = Sort.by(Sort.Direction.DESC, field);
        return orderRepository.findAll(sort);
    }

    // Paginated orders
    public List<ordertable> getPaginatedOrders(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return orderRepository.findAll(pageable).getContent();
    }
}
