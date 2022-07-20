package com.restaurant.cash.service;

import com.restaurant.cash.dto.CloseDay;
import com.restaurant.cash.repository.RepositoryCloseDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceCloseDay {

    @Autowired
    RepositoryCloseDay repositoryCloseDay;

    @Transactional
    public List<CloseDay> getCloseDay() {
        return repositoryCloseDay.findCloseDay();
    }

    @Transactional
    public String getTotalOrder() {
        return repositoryCloseDay.findTotalOrder();
    }



}
