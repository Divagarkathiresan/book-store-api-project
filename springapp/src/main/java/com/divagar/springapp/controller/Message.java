//message
package com.divagar.springapp.controller;
// import com.fasterxml.jackson.annotation.JsonIgnore;
// import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Students")
public class Message    
{
    @Autowired     //to automatically inject dependencies into Java classes
    @Column(name = "Std_id")
    @Id    //to specify the private key (PK)
    private int id;
    // @JsonProperty("Fname")
    @Column(name = "Std_FirstName")
    private String firstname;
    @Column(name = "Std_LastName")
    private String lastname;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Message(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    public Message() {
    }

    
}