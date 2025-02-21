package com.divagar.springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divagar.springapp.Entity.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher,Integer>{

}
