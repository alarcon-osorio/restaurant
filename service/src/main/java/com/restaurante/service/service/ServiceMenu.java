package com.restaurante.service.service;

import com.restaurante.service.entity.Menu;
import com.restaurante.service.repository.RepositoryMenu;
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

}
