package com.restaurant.kitchen.service;

import com.restaurant.kitchen.repository.RepositoryPrepared;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ServicePrepared {

    @Autowired
    RepositoryPrepared repositoryPrepared;

    @Transactional
    public void prepareOrder(long id){
        repositoryPrepared.prepareById(id);
    }

    @Transactional
    public void preparedOrder(long id){
        repositoryPrepared.preparedById(id);
    }


}
