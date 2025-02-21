package com.divagar.springapp.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PatchExchange;

import com.divagar.springapp.Entity.Book;
import com.divagar.springapp.Repository.BookRespository;
@Service
public class BookService 
{
    @Autowired
    BookRespository obj1;

	public Book AddNewBook(Book b)
	{
		return obj1.save(b);
	}

	public List<Book> GetAllBook()
	{
		return obj1.findAll();
	}

	public Optional<Book> GetSingleBook(int id)
	{
		return obj1.findById(id);
	}

	public Book UpdateSingleBook(int id,Book newbook)
	{
		return obj1.findById(id)
		.map(e->
		{
			if(newbook.getTitle()!=null)
			{
				e.setTitle(newbook.getTitle());
			}
			if(newbook.getGenre() != null)
			{
				e.setGenre(newbook.getGenre());
			}
			if(newbook.getPrice() != null)
			{
				e.setPrice(newbook.getPrice());
			}
			if(newbook.getDescription() != null)
			{
				e.setDescription(newbook.getDescription());
			}
			if(newbook.getEbook() != true ||newbook.getEbook() != false)
			{
				e.setEbook(newbook.getEbook());
			}
			return obj1.save(e);
		}).orElseThrow(()-> new RuntimeException ("The id is not valid"));
	}

	public void DeleteSingleBook(int id)
	{
		if(obj1.existsById(id))
		{
			obj1.deleteById(id);
		}
		else
		{
			throw new RuntimeException( "Id is not found");
		}
	}

	public Book updateBookByTitle(String title, Book newBook) 
	{
        return obj1.findByTitle(title)
                .map(existingBook -> 
				{
                    if (newBook.getTitle() != null) {
                        existingBook.setTitle(newBook.getTitle());
                    }
                    if (newBook.getGenre() != null) {
                        existingBook.setGenre(newBook.getGenre());
                    }
                    if (newBook.getPrice() != null) {
                        existingBook.setPrice(newBook.getPrice());
                    }
                    if (newBook.getDescription() != null) {
                        existingBook.setDescription(newBook.getDescription());
                    }
                    if (newBook.getEbook() != true || newBook.getEbook() != false) {  // Proper boolean check
                        existingBook.setEbook(newBook.getEbook());
                    }
                    return obj1.save(existingBook);
                })
                .orElseThrow(() -> new RuntimeException("The title is not valid"));
    }

	public List<Book> Sorting(String field)
    {
        Sort sort = Sort.by(Sort.Direction.DESC,field);
        return obj1.findAll(sort);
    }

    public List<Book> Pagination(int pagesize,int pagenumber)
    {
        Pageable page = PageRequest.of(pagenumber,pagesize);
        return obj1.findAll(page).getContent();
    }

	public List<Book> getPaginatedAndSortedGardeners(int pageNumber, int pageSize, String field) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC, field));
        return obj1.findAll(pageable).getContent();
    }

}