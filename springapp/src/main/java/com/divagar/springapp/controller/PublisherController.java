package com.divagar.springapp.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divagar.springapp.Entity.Publisher;
import com.divagar.springapp.service.PublisherService;

@RestController
@RequestMapping("/api/publisher")
public class PublisherController 
{
	@Autowired
	PublisherService publisherService;

	@PostMapping
	public ResponseEntity<Publisher> createNewPublisher(@RequestBody Publisher p)
	{
		return new ResponseEntity<>(publisherService.createNewPublisher(p),HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Publisher>> getAllPublishers()
	{
		return new ResponseEntity<>(publisherService.getAllPublishers(),HttpStatus.OK);
	}


	@DeleteMapping("/table")
	public ResponseEntity<String> DeleteAllPublishers() 
	{
    	publisherService.DeleteAllPublishers();
    	return new ResponseEntity<>("All publishers deleted successfully", HttpStatus.OK);
	}

}
