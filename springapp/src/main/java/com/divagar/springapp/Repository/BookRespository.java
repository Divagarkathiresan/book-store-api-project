//Repository
package com.divagar.springapp.Repository;
import java.util.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.divagar.springapp.Entity.Book;


@Repository
public interface BookRespository extends JpaRepository<Book,Integer>
{
	@Modifying
	@Query(value = "insert into Book values(?,?,?,?,?,?)",nativeQuery = true)
	void AddNewBook(int id,String title,String genre,String description,String price,boolean isEbook);
	@Query("select b from Book b")
	List<Book> GetAllBook();
	@Query("select b from Book b where b.id=?1")
	Optional<Book> GetSingleBook(int id);
	@Query("select b from Book b where b.title=?1")
	Optional<Book> findByTitle(String title);
	@Transactional
	@Query("Delete from Book b where b.id=?1")
	void DeleteSingleBook(int id);

}
