package com.divagar.springapp.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divagar.springapp.Entity.Book;
import com.divagar.springapp.service.BookService;
@RestController
public class BookController {
    @Autowired
    BookService obj1;
    @PostMapping("/book/post")
    public ResponseEntity<Book> AddNewBook(@RequestBody Book b)
    {
        return new ResponseEntity<>(obj1.AddNewBook(b),HttpStatus.OK);
    } 
    @GetMapping("/book/get")
    public ResponseEntity<List<Book>> GetAllBook()
    {
        return new ResponseEntity<>(obj1.GetAllBook(),HttpStatus.OK);
    }
    @GetMapping("/book/get/{id}")
    public ResponseEntity<Book> GetSingleBook(@PathVariable int id)
    {
        Optional<Book> book = obj1.GetSingleBook(id);
        if(book.isPresent())
        {
            return new ResponseEntity<>(book.get(),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/book/put/id/{id}")
    public ResponseEntity<Book> UpdateSingleBook(@PathVariable int id,@RequestBody Book b)
    {
        Optional<Book> book = obj1.GetSingleBook(id);
        if(book.isPresent())
        {
            return new ResponseEntity<>(obj1.UpdateSingleBook(id,b),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);   
        }

    }


    @PutMapping("/book/put/title/{title}")
    public Book updateSingleBookByTitle(@PathVariable String title, @RequestBody Book newBook) 
    {
        return obj1.updateBookByTitle(title, newBook);
    }   

    @DeleteMapping("/book/delete/{id}")
    public ResponseEntity<Book> DeleteSingleBook(@PathVariable int id)
    {Optional<Book> book =obj1.GetSingleBook(id);
        if(book.isPresent())
        {
            obj1.DeleteSingleBook(id);
            return new ResponseEntity<>(book.get(),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/book/sort/{field}")
    public ResponseEntity<List<Book>> Sorting(@PathVariable String field)
    {
        return new ResponseEntity<>(obj1.Sorting(field),HttpStatus.OK);
    }

    @GetMapping("/book/page/{pagesize}/{pagenumber}")
    public ResponseEntity<List<Book>> Pagination(@PathVariable int pagesize,@PathVariable int pagenumber)
    {
        return new ResponseEntity<>(obj1.Pagination(pagesize,pagenumber),HttpStatus.OK);
    }

    @GetMapping("/book/paginate/{pageSize}/{pageNumber}/{field}")
    public ResponseEntity<List<Book>> getPaginatedAndSortedGardeners(@PathVariable int pageSize,@PathVariable int pageNumber,@PathVariable String field) 
    {
        return new ResponseEntity<>(obj1.getPaginatedAndSortedGardeners(pageNumber, pageSize, field),HttpStatus.OK);
    }
}
