package com.restaurante.service.service;

import com.restaurante.service.entity.ServiceOrder;
import com.restaurante.service.repository.RepositoryOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceOrders {

    @Autowired
    RepositoryOrder repositoryOrder;

    public List<ServiceOrder> getServiceOrder(){
        return repositoryOrder.findAll();
    }

    public List<ServiceOrder> getByTableNumber(long table){
        return repositoryOrder.findByTableNumber(table);
    }

    public void saveOrder(ServiceOrder serviceOrder){
        repositoryOrder.save(serviceOrder);
    }

    @Transactional
    public void saveOrderTable(long table){
        repositoryOrder.saveOrderTable(table);
    }

    @Transactional
    public void saveOrderTableById(long id){
        repositoryOrder.saveOrderTableById(id);
    }

    @Transactional
    public void saveOrderServed(long id){
        repositoryOrder.saveOrderServed(id);
    }

    @Transactional
    public void orderTableCancel(long id){
        repositoryOrder.orderTableCancel(id);
    }

    @Transactional
    public void cancelOrder(long id){
        repositoryOrder.cancelOrder(id);
    }

    public List<String> getTableNumber(){
        return repositoryOrder.findByDistinctTableNumber();
    }

    public List<ServiceOrder> getNeatOrderByTable(long table){
        if (table == 0) {
            return repositoryOrder.findByNeatOrderByTableAll();
        }
        return repositoryOrder.findByNeatOrderByTable(table);
    }

    public List<ServiceOrder> findByPrepared(){
        return repositoryOrder.findByPrepared();
    }

    public ServiceOrder getServiceOrderById(long id){
        return repositoryOrder.findById(id).get();
    }


}
