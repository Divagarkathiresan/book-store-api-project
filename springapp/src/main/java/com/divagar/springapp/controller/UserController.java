package com.divagar.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.divagar.springapp.Entity.user;
import com.divagar.springapp.Entity.ordertable;
import com.divagar.springapp.service.userService;
import com.divagar.springapp.service.orderTableService;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private userService userService;
    
    @Autowired
    private orderTableService orderService;

    @PostMapping("/users")
    public ResponseEntity<?> addNewUser(@RequestBody user user) {
        if (user.getEmail().contains("@gmail.com")) {
            return new ResponseEntity<>(userService.AddNewuser(user), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Invalid email format", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/users")
    public ResponseEntity<List<user>> getAllUsers() {
        return new ResponseEntity<>(userService.GiveAlluser(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<user> getSingleUser(@PathVariable int id) {
        Optional<user> user = userService.GiveSingleuser(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<user> updateSingleUser(@PathVariable int id, @RequestBody user updatedUser) {
        try {
            return new ResponseEntity<>(userService.Updateuser(id, updatedUser), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteSingleUser(@PathVariable int id) {
        try {
            userService.Deleteuser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    @GetMapping("/users/page/{pageNumber}/{pageSize}")
    public ResponseEntity<List<user>> paginateUsers(@PathVariable int pageNumber, @PathVariable int pageSize) {
        return new ResponseEntity<>(userService.Pagination(pageNumber, pageSize), HttpStatus.OK);
    }
}
