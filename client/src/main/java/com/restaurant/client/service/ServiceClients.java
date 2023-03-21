package com.restaurant.client.service;

import com.restaurant.client.security.entity.Clients;
import com.restaurant.client.repository.RepositoryClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceClients {

    @Autowired
    RepositoryClients repositoryClients;

    public Clients getClientByEmail(String email){
        return repositoryClients.findClientByEmail(email);
    }

    public void saveClients(Clients clients){
        repositoryClients.save(clients);
    }

}
