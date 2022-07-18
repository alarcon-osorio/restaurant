package com.restaurant.kitchen.service;

import com.restaurant.kitchen.entity.ServiceOrder;
import com.restaurant.kitchen.repository.RepositoryOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOrders {

    @Autowired
    RepositoryOrders repositoryOrders;

    public List<ServiceOrder> getServiceOrderList(){
        return repositoryOrders.findAll();
    }

    public List<String> getTableNumberDistinct(){
        return repositoryOrders.findByDistinctTableNumber();
    }

    public List<ServiceOrder> getByTableNumber(long table){
        return repositoryOrders.findByTableNumber(table);
    }


}
