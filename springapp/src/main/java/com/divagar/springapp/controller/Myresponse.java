//Myresponse
package com.divagar.springapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Myresponse 
{
   
    @GetMapping("/jsonproof")
    public Message abc()
    {
    
      Message m = new Message(1, "Deepika", "Bollineni");
      return m;
   }
    
}