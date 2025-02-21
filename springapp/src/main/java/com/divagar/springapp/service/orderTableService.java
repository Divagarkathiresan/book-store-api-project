package com.divagar.springapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.divagar.springapp.Entity.ordertable;
import com.divagar.springapp.Repository.OrderRepository;

@Service
public class orderTableService {
	@Autowired
    OrderRepository obj2;
    public ordertable AddNewOrder(ordertable o)
    {
        return obj2.save(o);
    }

    public List<ordertable> GetAllOrders()
    {
        return obj2.findAll();
    }

    public Optional<ordertable> GetSingleOrder(int id)
    {
        return obj2.findById(id);
    }

    public ordertable UpdateSingleOrder(int id,ordertable order)
    {
        return obj2.findById(id)
        .map(o->
        {
            if(order.getOrderDate() != null)
            {
                o.setOrderDate(order.getOrderDate());
            }
            if(order.getTotalAmount() != null)
            {
                o.setTotalAmount(order.getTotalAmount());
            }
            return obj2.save(o);
        }).orElseThrow(()-> new RuntimeException("Id not found"));
    }

    public void DeleteSingleOrder(int id)
    {
        if(obj2.existsById(id))
        {
            obj2.deleteById(id);
        }
        else
        {
            throw new RuntimeException("Id not found");
        }
    }

	public List<ordertable> GetSortedOrder(String field)
	{
		Sort sort = Sort.by(Sort.Direction.DESC,field);
		return obj2.findAll(sort);
	}
	
	public List<ordertable> Pagination(int pagenumber,int pagesize)
    {
        Pageable page = PageRequest.of(pagenumber,pagesize);
        return obj2.findAll(page).getContent();
    }
}
