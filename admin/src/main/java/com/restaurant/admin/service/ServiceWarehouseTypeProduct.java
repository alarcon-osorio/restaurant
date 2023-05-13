package com.restaurant.admin.service;

import com.restaurant.admin.entity.WarehouseTypeProduct;
import com.restaurant.admin.repository.RepositoryWarehouseTypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceWarehouseTypeProduct {

    @Autowired
    RepositoryWarehouseTypeProduct repositoryWarehouseTypeProduct;

    public List<WarehouseTypeProduct> warehouseTypeProductList(){
        return repositoryWarehouseTypeProduct.findAll();
    }

    public WarehouseTypeProduct warehouseTypeProductById(String id){
        return repositoryWarehouseTypeProduct.findById(Long.valueOf(id)).get();
    }

}
