package com.divagar.springapp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.divagar.springapp.Entity.Publisher;
import com.divagar.springapp.Repository.PublisherRepository;

@Service
public class PublisherService {
	@Autowired
	PublisherRepository publisherRepository;

	public Publisher createNewPublisher(Publisher p)
	{
		return publisherRepository.save(p);
	}

	public List<Publisher> getAllPublishers()
	{
		return publisherRepository.findAll();
	}

	public void  DeleteAllPublishers()
	{
		publisherRepository.deleteByTable();
	}
}
