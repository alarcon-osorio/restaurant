package com.restaurante.service.service;

import com.restaurante.service.entity.ServiceOrder;
import com.restaurante.service.repository.RepositoryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceOrders {

    @Autowired
    RepositoryOrder repositoryOrder;

    public void saveOrder(ServiceOrder serviceOrder){
        repositoryOrder.save(serviceOrder);
    }

}
