package com.restaurant.admin.service;

import com.restaurant.admin.dto.MenuIncludesDTO;
import com.restaurant.admin.entity.MenuIncludes;
import com.restaurant.admin.repository.RepositoryMenuIncludes;
import com.restaurant.admin.repository.RepositoryMenuIncludesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuIncludes {

    @Autowired
    RepositoryMenuIncludes repositoryMenuIncludes;

    @Autowired
    RepositoryMenuIncludesDTO repositoryMenuIncludesDTO;

    public List<MenuIncludesDTO> getMenuIncludes(){
        return repositoryMenuIncludesDTO.findAll();
    }

    public List<MenuIncludes> getMenuIncludesList(){
        return repositoryMenuIncludes.findAll();
    }

    public List<MenuIncludes> getMenuIncludesIdMenu(long idMenu){
        return repositoryMenuIncludes.findByIdMenu(idMenu);
    }

    public MenuIncludes getMenuIncludesById(long id){
        return repositoryMenuIncludes.findById(id).get();
    }

    public void saveMenuInlcudes(MenuIncludes menuIncludes){
        repositoryMenuIncludes.save(menuIncludes);
    }

    public void deleteMenuInclcudes(long id){
        repositoryMenuIncludes.deleteById(id);
    }
}
