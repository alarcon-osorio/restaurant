package com.restaurant.admin.service;

import com.restaurant.admin.repository.RepositoryMeasureUnit;
import com.restaurant.admin.entity.MeasureUnit;
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

    public MeasureUnit getMeasureUnitById(long id){
        return repositoryMeasureUnit.findById(id).get();
    }

    public void saveMeasureUnits(MeasureUnit measureUnit){
        repositoryMeasureUnit.save(measureUnit);
    }

    public void deleteMeasureUnits(long id){
        repositoryMeasureUnit.deleteById(id);
    }
}
