package com.restaurant.cash.service;

import com.restaurant.cash.entity.ServiceOrder;
import com.restaurant.cash.repository.RepositoryOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class ServiceOrders {

    @Autowired
    RepositoryOrders repositoryOrders;

    public List<ServiceOrder> getServiceOrdersByTable(long table){
        return repositoryOrders.getServiceOrdersByTable(table);
    }

    @Transactional
    public List<String> getTableNumberDistinct(){
        return repositoryOrders.findByDistinctTableNumber();
    }

    @Transactional
    public String getTotalOrder(long table){
        return repositoryOrders.findTotalOrder(table);
    }

}
