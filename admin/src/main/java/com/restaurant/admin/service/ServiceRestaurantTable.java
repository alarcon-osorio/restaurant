package com.restaurant.admin.service;

import com.restaurant.admin.entity.RestaurantTable;
import com.restaurant.admin.repository.RepositoryRestaurantTable;
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
