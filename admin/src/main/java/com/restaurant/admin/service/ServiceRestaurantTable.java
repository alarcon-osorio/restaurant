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

    public RestaurantTable getRestaurantTableById(long id){
        return repositoryRestaurantTable.findById(id).get();
    }

    public void saveRestaurantTable(RestaurantTable restaurantTable){
        repositoryRestaurantTable.save(restaurantTable);
    }

    public void deleteRestaurantTable(long id){
        repositoryRestaurantTable.deleteById(id);
    }

}
