package com.restaurant.client.service;

import com.restaurant.client.entity.MenuOptional;
import com.restaurant.client.repository.RepositoryMenuOptional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuOptional {

    @Autowired
    RepositoryMenuOptional repositoryMenuOptional;

    public List<MenuOptional> getMenuOptional(){
        return repositoryMenuOptional.findAll();
    }

    public List<MenuOptional> getMenuOptionalByIdMenu(long idMenu){
        return repositoryMenuOptional.findByIdMenu(idMenu);
    }

}
