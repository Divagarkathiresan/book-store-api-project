package com.divagar.springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divagar.springapp.Entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>{

}
