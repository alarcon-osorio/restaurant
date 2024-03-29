package com.restaurant.client.service;

import com.restaurant.client.entity.Menu;
import com.restaurant.client.repository.RepositoryMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenu {

    @Autowired
    RepositoryMenu repositoryMenu;

    public List<Menu> getMenu(){
        return repositoryMenu.findAll();
    }

    public Menu getMenuId(long id){
        return repositoryMenu.findById(id).get();
    }

    public Menu ordered(Menu menu){
        return repositoryMenu.save(menu);
    }

    public List<Menu> getMenuTypeId(long id){
        return repositoryMenu.findbyMenuTypeId(id);
    }

    public Menu getMenuPersonalByIdUser(long id){
        return repositoryMenu.findById(id).get();
    }

}
