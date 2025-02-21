package com.divagar.springapp.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.divagar.springapp.Entity.user;
import com.divagar.springapp.Repository.userRepository;

@Service
public class userService {
	@Autowired
    userRepository obj;
    public user AddNewuser(user a)
    {
        return obj.save(a);
    }

    public List<user> GiveAlluser()
    {
        return obj.findAll();
    }

    public Optional<user> GiveSingleuser(int id)
    {
        return obj.findById(id);
    }

    public user Updateuser(int id,user Updateduser)
    {
       return obj.findById(id)
        .map(e->
        {
            if(Updateduser.getName() != null)
            {
                e.setName(Updateduser.getName());
            }
            if(Updateduser.getEmail() != null)
            {
                e.setEmail(Updateduser.getEmail());
            }
            return obj.save(e);
        }).orElseThrow(()->new RuntimeException("user Id not valid")); 
    }


    public void Deleteuser(int id)
    {
        if(obj.existsById(id))
        {
            obj.deleteById(id);
        }
        else
        {
            throw new RuntimeException("user id not Found");
        }
    }

    public List<user> Sorting(String field)
    {
        Sort sort = Sort.by(Sort.Direction.DESC,field);
        return obj.findAll(sort);
    }

    public List<user> Pagination(int pagenumber,int pagesize)
    {
        Pageable page = PageRequest.of(pagenumber,pagesize);
        return obj.findAll(page).getContent();
    }

}
