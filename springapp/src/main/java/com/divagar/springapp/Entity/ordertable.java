package com.divagar.springapp.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ordertable")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ordertable 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Changed to IDENTITY for better DB handling
    @Column(name = "order_id")
    private int id;

    @Column(name = "order_date", nullable = false)
    private String orderDate;

    @Column(name = "order_total_amount", nullable = false)
    private double totalAmount; // Changed from String to double for numerical calculations


    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false) // Foreign key reference to Book
    @JsonBackReference
    private Book book;

}
