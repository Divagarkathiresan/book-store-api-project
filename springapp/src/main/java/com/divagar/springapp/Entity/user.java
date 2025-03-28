package com.divagar.springapp.Entity;
import java.util.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user" , uniqueConstraints = {@UniqueConstraint(columnNames = "user_email")})

public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_name")
    private String name;
    @Column(name = "user_email" , unique = true)
    private String email;
    // @JsonIgnore
    @Column(name = "user_password")
    private String password;

}