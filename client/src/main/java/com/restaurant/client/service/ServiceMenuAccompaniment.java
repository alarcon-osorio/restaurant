package com.restaurant.client.service;

import com.restaurant.client.entity.MenuAccompaniment;
import com.restaurant.client.repository.RepositoryMenuAccompaniment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMenuAccompaniment {

    @Autowired
    RepositoryMenuAccompaniment repositoryMenuAccompaniment;

    public List<MenuAccompaniment> getMenuAccompanimentList(){
        return repositoryMenuAccompaniment.findAll();
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

}
