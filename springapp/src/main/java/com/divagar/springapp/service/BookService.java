package com.divagar.springapp.service;

import com.divagar.springapp.Entity.Book;
import com.divagar.springapp.Repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRespository bookRepository;

    // Add a new book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    // Get all books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get a book by ID
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
    }

    // Get a book by title
    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    // Update a book by ID
    public Book updateBook(int id, Book updatedBook) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setDescription(updatedBook.getDescription());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setEbook(updatedBook.isEbook());
            return bookRepository.save(existingBook);
        }).orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
    }

    // Delete a book by ID
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    // Sort books by a given field
    public List<Book> sortBooks(String field) {
        return bookRepository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    // Pagination of books
    public List<Book> paginateBooks(int pageSize, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return bookRepository.findAll(pageable).getContent();
    }

    // Pagination + Sorting
    public List<Book> paginateAndSortBooks(int pageSize, int pageNumber, String field) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, field));
        return bookRepository.findAll(pageable).getContent();
    }
}
