package com.restaurant.cash.service;

import com.restaurant.cash.entity.Discount;
import com.restaurant.cash.repository.RepositoryDiscount;
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
