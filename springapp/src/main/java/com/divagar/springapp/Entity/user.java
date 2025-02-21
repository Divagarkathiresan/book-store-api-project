package com.divagar.springapp.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
@Table(name="user" , uniqueConstraints = {@UniqueConstraint(columnNames = "user_email")})

public class user {
    @Id
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email" , unique = true)
    private String email;
    // @JsonIgnore
    @Column(name = "user_password")
    private String password;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public user(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public user() {
    }

}