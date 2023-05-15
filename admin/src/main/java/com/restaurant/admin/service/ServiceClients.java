package com.restaurant.admin.service;

import com.restaurant.admin.entity.Clients;
import com.restaurant.admin.repository.RepositoryClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceClients {

    @Autowired
    RepositoryClients repositoryClients;

    public List<Clients> findClients(){
        return repositoryClients.findAll();
    }

}