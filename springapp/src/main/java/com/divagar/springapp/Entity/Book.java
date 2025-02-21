package com.divagar.springapp.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	@Column(name = "book_id")
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(name = "book_title")
    public String title;
    @Column(name = "book_genre")
    public String genre;
    @Column(name = "book_description")
    public String description;
    @Column(name = "book_price")
    public String price;
    @Column(name = "book_IsBook")
    public boolean isEbook;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public boolean getEbook() {
        return isEbook;
    }
    public void setEbook(boolean isEbook) {
        this.isEbook = isEbook;
    }
    
    public Book(int id, String title, String genre, String description, String price, boolean isEbook) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.price = price;
        this.isEbook = isEbook;
    }

    public Book() {
    }
    
}