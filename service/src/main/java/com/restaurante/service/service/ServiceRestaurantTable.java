package com.restaurante.service.service;

import com.restaurante.service.entity.RestaurantTable;
import com.restaurante.service.repository.RepositoryRestaurantTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceRestaurantTable {

    @Autowired
    RepositoryRestaurantTable repositoryRestaurantTable;

    public List<RestaurantTable> getRestaurantTableList(){
        return repositoryRestaurantTable.findAll();
    }

}
