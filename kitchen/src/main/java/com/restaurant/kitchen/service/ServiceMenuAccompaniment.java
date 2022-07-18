package com.restaurant.kitchen.service;

import com.restaurant.kitchen.entity.MenuAccompaniment;
import com.restaurant.kitchen.repository.RepositoryMenuAccompaniment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuAccompaniment {

    @Autowired
    RepositoryMenuAccompaniment repositoryMenuAccompaniment;

    public List<MenuAccompaniment> getMenuAccompaniment(){
        return repositoryMenuAccompaniment.findAll();
    }

}
