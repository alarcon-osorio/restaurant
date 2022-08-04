package com.restaurant.admin.service;


import com.restaurant.admin.dto.MenuDTO;
import com.restaurant.admin.entity.Menu;
import com.restaurant.admin.repository.RepositoryMenu;
import com.restaurant.admin.repository.RepositoryMenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenu {

    @Autowired
    RepositoryMenu repositoryMenu;

    @Autowired
    RepositoryMenuDTO repositoryMenuDTO;

    public List<MenuDTO> getMenu(){
        return repositoryMenuDTO.findAll();
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
