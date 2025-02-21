package com.divagar.springapp.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.divagar.springapp.controller.Message;
@Repository
public interface MessageRepo extends JpaRepository<Message,Integer>    //Message → This is the entity class that represents the database table.Integer → This is the data type of the primary key (ID) of the Message entity.
// we should give as Integer not as int
{
	
}

// public interface MessageRepo extends JpaRepository<Message,Integer>{

	
// }