package com.restaurant.client.service;

import com.restaurant.client.entity.MenuType;
import com.restaurant.client.repository.RepositoryMenuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuType {

    @Autowired
    RepositoryMenuType repositoryMenuType;

    public List<MenuType> getMenuType(){
        return repositoryMenuType.findAll();
    }

    public MenuType getMenuTypeId(long id){
        return repositoryMenuType.findById(id).get();
    }

}
