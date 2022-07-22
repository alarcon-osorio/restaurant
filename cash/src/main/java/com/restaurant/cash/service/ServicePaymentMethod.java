package com.restaurant.cash.service;

import com.restaurant.cash.entity.PaymentMethod;
import com.restaurant.cash.repository.RepositoryPaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServicePaymentMethod {

    @Autowired
    RepositoryPaymentMethod repositoryPaymentMethod;

    public List<PaymentMethod> getPaymentMethod(){
        return repositoryPaymentMethod.findAll();
    }

    @Transactional
    public void savePaymentMethod(String method, long table) {
        repositoryPaymentMethod.savePaymentMethod(method, table);
    }

}
