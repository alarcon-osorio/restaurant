package com.restaurant.admin.service;

import com.restaurant.admin.entity.MenuType;
import com.restaurant.admin.repository.RepositoryMenuType;
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

    public void saveMenuType(MenuType menuType){
        repositoryMenuType.save(menuType);
    }

    public void deleteById(long id){
        repositoryMenuType.deleteById(id);
    }

}
