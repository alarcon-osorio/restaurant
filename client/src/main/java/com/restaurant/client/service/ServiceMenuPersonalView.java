package com.restaurant.client.service;

import com.restaurant.client.entity.menu_personal.MenuPersonal;
import com.restaurant.client.repository.RepositoryMenuPersonalView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuPersonalView {

    @Autowired
    RepositoryMenuPersonalView repositoryMenuPersonalView;

    public List<MenuPersonal> getMenuPersonalList(){
        return repositoryMenuPersonalView.findAll();
    }

    public List<MenuPersonal> getMenuPersonalByUsername(String username){
        return repositoryMenuPersonalView.findByUsername(username);
    }

    public void saveMenuPersonalView(MenuPersonal menuPersonal){
        repositoryMenuPersonalView.save(menuPersonal);
    }

}
