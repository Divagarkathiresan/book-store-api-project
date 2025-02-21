package com.divagar.springapp.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.divagar.springapp.Entity.ordertable;

public interface OrderRepository extends JpaRepository<ordertable,Integer>{

    @Query(value = "insert into ordertable values(?,?,?)", nativeQuery=true)
    void AddNewOrder(int id,String orderDate , String totalAmount);
    @Query("select o from ordertable o")
    List<ordertable> GetAllOrders();
    @Query("select o from ordertable o where o.id=?1")
    Optional<ordertable> GetSingleOrder(int id);
}
