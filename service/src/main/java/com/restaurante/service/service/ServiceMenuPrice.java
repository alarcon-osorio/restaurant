package com.restaurante.service.service;

import com.restaurante.service.entity.MenuPrice;
import com.restaurante.service.repository.RepositoryMenuPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceMenuPrice {

    @Autowired
    RepositoryMenuPrice repositoryMenuPrice;

    public MenuPrice getMenuPrice(long id){
        return repositoryMenuPrice.findById(id).get();
    }

}
