package com.restaurant.kitchen.service;

import com.restaurant.kitchen.entity.ServiceOrder;
import com.restaurant.kitchen.repository.RepositoryOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceOrders {

    @Autowired
    RepositoryOrders repositoryOrders;

    @Transactional
    public List<ServiceOrder> getServiceOrderList(){
        return repositoryOrders.findAll();
    }

    @Transactional
    public List<String> getTableNumberDistinct(){
        return repositoryOrders.findByDistinctTableNumber();
    }

    @Transactional
    public List<ServiceOrder> getByTableNumber(long table){
        return repositoryOrders.findByTableNumber(table);
    }

    @Transactional
    public ServiceOrder getServiceOrderById(long id){
        return repositoryOrders.findById(id).get();
    }


}
