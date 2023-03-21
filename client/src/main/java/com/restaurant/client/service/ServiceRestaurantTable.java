package com.restaurant.client.service;

import com.restaurant.client.entity.RestaurantTable;
import com.restaurant.client.repository.RepositoryRestaurantTable;
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
