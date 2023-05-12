package com.restaurant.admin.service;

import com.restaurant.admin.dto.MenuOptionalDTO;
import com.restaurant.admin.entity.MenuOptional;
import com.restaurant.admin.repository.RepositoryMenuOptional;
import com.restaurant.admin.repository.RepositoryMenuOptionalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuOptional {

    @Autowired
    RepositoryMenuOptional repositoryMenuOptional;

    @Autowired
    RepositoryMenuOptionalDTO repositoryMenuOptionalDTO;

    public List<MenuOptionalDTO> getMenuOptionals(){
        return repositoryMenuOptionalDTO.findAll();
    }
    public List<MenuOptional> getMenuOptional(){
        return repositoryMenuOptional.findAll();
    }

    public List<MenuOptional> getMenuOptionalByIdMenu(long idMenu){
        return repositoryMenuOptional.findByIdMenu(idMenu);
    }

    public MenuOptional getMenuOptionalById(long id){
        return repositoryMenuOptional.findById(id).get();
    }

    public void saveMenuOptional(MenuOptional menuOptional){
        repositoryMenuOptional.save(menuOptional);
    }

    public void deleteMenuOptional(long id){
        repositoryMenuOptional.deleteById(id);
    }

}
