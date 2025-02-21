package com.divagar.springapp.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.divagar.springapp.Repository.MessageRepo;
import com.divagar.springapp.controller.Message;
@Service
public class MessageService {
	@Autowired
	MessageRepo obj;
	public Message AddNewMessage(Message a)        //post
	{
		return obj.save(a);
	}
	public List<Message> GettAllMessage()   // get
	{
		return obj.findAll();
	}
	public Optional<Message>  GetByID(int Id)     // get  
	//Optional -> Prevents NullPointerException if the ID is not found.
	{
		return obj.findById(Id);
	}

	public Message updateMessage(int id, Message newMessage) {      //put
        return obj.findById(id)
		.map(existingMessage -> 
		{
            // existingMessage.setId(newMessage.getId());
            // existingMessage.setFirstname(newMessage.getFirstname());
			// existingMessage.setLastname(newMessage.getLastname());
			if(newMessage.getFirstname() != null)
			{
				existingMessage.setFirstname(newMessage.getFirstname());
			}
			if(newMessage.getLastname() != null)
			{
				existingMessage.setLastname(newMessage.getLastname());
			}
            return obj.save(existingMessage);
        }).orElseThrow(() -> new RuntimeException("Message not found with id " + id));
    }


	public void deleteMessage(int id)         //delete
	{
	   if (obj.existsById(id))
		{
		   obj.deleteById(id);
	   } 
	   else 
	   {
		   throw new RuntimeException("Message not found with id " + id);
		}
	}

}
