package com.divagar.springapp.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.divagar.springapp.controller.*;
import com.divagar.springapp.service.MessageService;

@RestController
public class MessageController {

    @Autowired
    MessageService obj;    

    @PostMapping("/post")
    public ResponseEntity<Message> addMessage(@RequestBody Message a) 
    {
        return new ResponseEntity<>(obj.AddNewMessage(a), HttpStatus.OK);
    }

    @GetMapping("/getallData")
    public ResponseEntity<List<Message>> GetMessage() 
    {
        return new ResponseEntity<>(obj.GettAllMessage(), HttpStatus.OK);
    }
    
    @GetMapping("/messages/{id}")
    public ResponseEntity<Message> GetDataByID(@PathVariable int id) 
    {
        Optional <Message> message = obj.GetByID(id);
        if(message.isPresent())
        {
            return new ResponseEntity<>(message.get(),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @PutMapping("/messages/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable int id, @RequestBody Message newMessage) 
    {
        try {
            return new ResponseEntity<>(obj.updateMessage(id, newMessage), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/messages/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable int id) {
        try 
        {
            obj.deleteMessage(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
}
