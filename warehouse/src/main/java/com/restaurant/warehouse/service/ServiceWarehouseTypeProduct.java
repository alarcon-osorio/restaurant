package com.restaurant.warehouse.service;

import com.restaurant.warehouse.entity.WarehouseTypeProduct;
import com.restaurant.warehouse.repository.RepositoryWarehouseTypeProduct;
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

}
