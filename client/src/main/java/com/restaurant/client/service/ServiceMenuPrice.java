package com.restaurant.client.service;

import com.restaurant.client.entity.MenuPrice;
import com.restaurant.client.repository.RepositoryMenuPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ServiceMenuPrice {

    @Autowired
    RepositoryMenuPrice repositoryMenuPrice;

    public MenuPrice getMenuPrice(long id){
        return repositoryMenuPrice.findById(id).get();
    }

}
