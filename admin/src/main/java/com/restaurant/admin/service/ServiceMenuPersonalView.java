package com.restaurant.admin.service;


import com.restaurant.admin.dto.MenuPersonalDTO;
import com.restaurant.admin.entity.MenuPersonal;
import com.restaurant.admin.repository.RepositoryMenuPersonalDTO;
import com.restaurant.admin.repository.RepositoryMenuPersonalView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuPersonalView {

    @Autowired
    RepositoryMenuPersonalView repositoryMenuPersonalView;

    @Autowired
    RepositoryMenuPersonalDTO repositoryMenuPersonalDTO;

    public List<MenuPersonal> getMenuPersonalList(){
        return repositoryMenuPersonalView.findAll();
    }

    public List<MenuPersonalDTO> getMenuPersonalListDTO(){
        return repositoryMenuPersonalDTO.findByPersonalMenuDTO();
    }

    public MenuPersonal getMenuPersonalById(long id){
        return repositoryMenuPersonalView.findById(id);
    }

    public List<MenuPersonal> getMenuPersonalByUsername(String username){
        return repositoryMenuPersonalView.findByUsername(username);
    }
    public void saveMenuPersonalView(MenuPersonal menuPersonal){
        repositoryMenuPersonalView.save(menuPersonal);
    }

    public void deleteMenuPersonal(long menuIdPersonal){
        repositoryMenuPersonalView.deleteById(menuIdPersonal);
    }

    public List<MenuPersonalDTO> getMenuPersonalByNameAndUsername(String username){
        return repositoryMenuPersonalDTO.findByPersonalFormAndUsername(username);
    }

}
