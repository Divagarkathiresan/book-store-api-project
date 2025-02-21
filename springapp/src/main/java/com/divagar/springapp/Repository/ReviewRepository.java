package com.divagar.springapp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.divagar.springapp.Entity.Review;

public interface ReviewRepository extends JpaRepository<Review,Integer>{

}
