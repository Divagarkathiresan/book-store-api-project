package com.divagar.springapp.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.divagar.springapp.Entity.OrderItem;

import jakarta.transaction.Transactional;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>{

	@Modifying
	// @Query("select O from OrderItem O where O.quantity=?1")
	// Optional<OrderItem> getSingleOrderItembyQuantity(int quantity);

	@Query("SELECT o FROM OrderItem o WHERE o.quantity = ?1")
	List<OrderItem> findByQuantity(int quantity);
}
