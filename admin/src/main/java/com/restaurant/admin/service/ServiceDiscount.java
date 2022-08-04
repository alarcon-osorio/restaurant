package com.restaurant.admin.service;

import com.restaurant.admin.entity.Discount;
import com.restaurant.admin.repository.RepositoryDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceDiscount {

    @Autowired
    RepositoryDiscount repositoryDiscount;

    public List<Discount> getDiscount(){
        return repositoryDiscount.findAll();
    }

}
