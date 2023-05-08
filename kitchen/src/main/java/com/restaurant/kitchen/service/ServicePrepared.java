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

    @Transactional
    public void servedOrder(long id){
        repositoryPrepared.servedById(id);
    }

    @Transactional
    public void prepareOrderByTable(long table){
        repositoryPrepared.prepareByTable(table);
    }

    @Transactional
    public void preparedOrderByTable(long table){
        repositoryPrepared.preparedByTable(table);
    }

    @Transactional
    public void servedOrderByTable(long table){
        repositoryPrepared.servedByTable(table);
    }


}
