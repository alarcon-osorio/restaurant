package com.restaurant.admin.service;

import com.restaurant.admin.entity.Modules;
import com.restaurant.admin.repository.RepositoryModules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceModules {

    @Autowired
    RepositoryModules repositoryModules;

    public List<Modules> findModules(){
        return repositoryModules.findAll();
    }


}
