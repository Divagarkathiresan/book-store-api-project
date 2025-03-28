package com.divagar.springapp.Entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_title", nullable = false)
    private String title;

    @Column(name = "book_genre")
    private String genre;

    @Column(name = "book_author")
    private String author;

    @Column(name = "book_description")
    private String description;

    @Column(name = "book_price", nullable = false)
    private double price;  

    @Column(name = "book_isEbook")
    private boolean ebook; 

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ordertable> orders; // Corrected reference to Ordertable entity
}
