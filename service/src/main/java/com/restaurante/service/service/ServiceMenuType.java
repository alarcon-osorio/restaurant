package com.restaurante.service.service;

import com.restaurante.service.entity.MenuType;
import com.restaurante.service.repository.RepositoryMenuType;
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
