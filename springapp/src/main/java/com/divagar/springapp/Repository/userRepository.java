package com.divagar.springapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divagar.springapp.Entity.user;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface userRepository extends JpaRepository<user,Integer>
{
	// @Modifying
    @Query(value="insert into user (id,name,email,password) values (?,?,?,?)",nativeQuery = true)
    void AddNewuser(int id,String name , String email,String password);
    @Query("select a from user a")
    List<user> GiveAlluser();
    @Query("Select a from user a where a.id=?1")
    Optional<user> GiveSingleuser();
}



