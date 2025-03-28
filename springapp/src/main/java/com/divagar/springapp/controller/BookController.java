package com.divagar.springapp.controller;
import com.divagar.springapp.Entity.Book;
import com.divagar.springapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books") // Base mapping for the controller
public class BookController 
{

    @Autowired
    private BookService bookService;

    // Create a new book
    @PostMapping("/add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // Get all books
    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    // Get a single book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Optional<Book> book = bookService.getBookById(id);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get a book by title
    @GetMapping("/title/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
        Optional<Book> book = bookService.getBookByTitle(title);
        return book.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update a book by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            return new ResponseEntity<>(bookService.updateBook(id, updatedBook), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Delete a book by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        Optional<Book> book = bookService.getBookById(id);
        if (book.isPresent()) {
            bookService.deleteBook(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Sort books by a given field (e.g., title, price, author)
    @GetMapping("/sort/{field}")
    public ResponseEntity<List<Book>> sortBooks(@PathVariable String field) {
        return new ResponseEntity<>(bookService.sortBooks(field), HttpStatus.OK);
    }

    // Pagination of books
    @GetMapping("/page/{pageSize}/{pageNumber}")
    public ResponseEntity<List<Book>> paginateBooks(@PathVariable int pageSize, @PathVariable int pageNumber) {
        return new ResponseEntity<>(bookService.paginateBooks(pageSize, pageNumber), HttpStatus.OK);
    }

    // Pagination + Sorting
    @GetMapping("/paginate/{pageSize}/{pageNumber}/{field}")
    public ResponseEntity<List<Book>> paginateAndSortBooks(
            @PathVariable int pageSize, @PathVariable int pageNumber, @PathVariable String field) {
        return new ResponseEntity<>(bookService.paginateAndSortBooks(pageSize, pageNumber, field), HttpStatus.OK);
    }
}
