package com.restaurant.admin.service;

import com.restaurant.admin.entity.ServiceOrder;
import com.restaurant.admin.repository.RepositoryOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ServiceOrders {

    @Autowired
    RepositoryOrders repositoryOrders;

    public List<ServiceOrder> getServiceOrders(){
        return repositoryOrders.findAll();
    }

    public String getTotalOrders(){
        return repositoryOrders.findTotalOrders();
    }

    public String getTotalAttend(){
        return repositoryOrders.findTotalAttend();
    }

    public String getPendingAttend(){
        return repositoryOrders.findPendingAttend();
    }

    public String getcancelled(){
        return repositoryOrders.findCancelled();
    }

}
