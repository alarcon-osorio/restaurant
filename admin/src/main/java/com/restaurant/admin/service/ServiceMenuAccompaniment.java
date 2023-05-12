package com.restaurant.admin.service;

import com.restaurant.admin.dto.MenuAccompanimentDTO;
import com.restaurant.admin.entity.MenuAccompaniment;
import com.restaurant.admin.repository.RepositoryMenuAccompaniment;
import com.restaurant.admin.repository.RepositoryMenuAccompanimentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuAccompaniment {

    @Autowired
    RepositoryMenuAccompaniment repositoryMenuAccompaniment;

    @Autowired
    RepositoryMenuAccompanimentDTO repositoryMenuAccompanimentDTO;


    public List<MenuAccompanimentDTO> getMenuAccompanimentList(){
        return repositoryMenuAccompanimentDTO.findAll();
    }

    public MenuAccompaniment getMenuAccompanimentId(long id){
        return repositoryMenuAccompaniment.findById(id).get();
    }

    public List<MenuAccompaniment> getMenuAccompanimentMenuId(long id){
        return repositoryMenuAccompaniment.findByMenuId(id);
    }

    public List<String> getMenuAccompanimentDistinct(){
        return repositoryMenuAccompaniment.findAccompanimentDistinct();
    }

    public void saveMenuAccompaniment(MenuAccompaniment menuAccompaniment){
        repositoryMenuAccompaniment.save(menuAccompaniment);
    }

    public void deleteMenuAccompaniment(long id){
        repositoryMenuAccompaniment.deleteById(id);
    }

}
