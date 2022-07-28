package com.restaurant.warehouse.service;

import com.restaurant.warehouse.entity.Inventory;
import com.restaurant.warehouse.repository.RepositoryInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServiceInventory {

    @Autowired
    RepositoryInventory repositoryInventory;

    public List<Inventory> findInventory(){
        return repositoryInventory.findAll();
    }

    public Inventory findInventoryById(long id){
        return repositoryInventory.findById(id).get();
    }

    public void saveInventory(Inventory inventory){
        repositoryInventory.save(inventory);
    }

    public void deleteInventory(long id){
        repositoryInventory.deleteById(id);
    }




}
