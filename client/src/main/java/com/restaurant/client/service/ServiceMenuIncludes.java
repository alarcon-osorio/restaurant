package com.restaurant.client.service;

import com.restaurant.client.entity.MenuIncludes;
import com.restaurant.client.repository.RepositoryMenuIncludes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuIncludes {

    @Autowired
    RepositoryMenuIncludes repositoryMenuIncludes;

    public List<MenuIncludes> getMenuIncludesList(){
        return repositoryMenuIncludes.findAll();
    }

    public List<MenuIncludes> getMenuIncludesIdMenu(long idMenu){
        return repositoryMenuIncludes.findByIdMenu(idMenu);
    }
}
