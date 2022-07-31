package com.restaurant.warehouse.service;

import com.restaurant.warehouse.entity.MeasureUnit;
import com.restaurant.warehouse.repository.RepositoryMeasureUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceMeasureUnit {

    @Autowired
    RepositoryMeasureUnit repositoryMeasureUnit;

    public List<MeasureUnit> getMeasureUnit(){
        return repositoryMeasureUnit.findAll();
    }
}
