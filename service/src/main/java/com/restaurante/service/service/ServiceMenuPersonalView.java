package com.restaurante.service.service;


import com.restaurante.service.dto.MenuPersonalDTO;
import com.restaurante.service.entity.MenuPersonal;
import com.restaurante.service.repository.RepositoryMenuPersonalDTO;
import com.restaurante.service.repository.RepositoryMenuPersonalView;
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

    public List<MenuPersonalDTO> getMenuPersonaDTOlList(){
        return repositoryMenuPersonalDTO.findPersonal();
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


}
