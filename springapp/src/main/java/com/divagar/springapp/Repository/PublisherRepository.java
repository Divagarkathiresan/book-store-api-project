package com.divagar.springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.divagar.springapp.Entity.Publisher;

import jakarta.transaction.Transactional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer>
{
	@Modifying
	@Transactional
	@Query("DELETE FROM Publisher")  // Correct JPQL for deleting all rows
	void deleteByTable();

}
