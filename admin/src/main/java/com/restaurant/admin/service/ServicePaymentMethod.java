package com.restaurant.admin.service;

import com.restaurant.admin.entity.PaymentMethod;
import com.restaurant.admin.repository.RepositoryPaymentMethod;
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

    public PaymentMethod getPaymentMethodById(long id) {
        return repositoryPaymentMethod.findById(id).get();
    }

    @Transactional
    public void savePaymentMethodByDiscount(String method, long discount, long table) {
        repositoryPaymentMethod.savePaymentMethod(method, discount, table);
    }

    @Transactional
    public void savePaymentMethod(PaymentMethod paymentMethod) {
        repositoryPaymentMethod.save(paymentMethod);
    }

    @Transactional
    public void deletePaymentMethod(long id) {
        repositoryPaymentMethod.deleteById(id);
    }


}
