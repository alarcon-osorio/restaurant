package com.restaurant.admin.controller;

import com.restaurant.admin.entity.Inventory;
import com.restaurant.admin.entity.MeasureUnit;
import com.restaurant.admin.entity.WarehouseTypeProduct;
import com.restaurant.admin.service.ServiceInventory;
import com.restaurant.admin.service.ServiceMeasureUnit;
import com.restaurant.admin.service.ServiceWarehouseTypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebInventory {

    @Autowired
    ServiceInventory serviceInventory;

    @Autowired
    ServiceMeasureUnit serviceMeasureUnit;

    @Autowired
    ServiceWarehouseTypeProduct serviceWarehouseTypeProduct;


    @RequestMapping("/inventory")
    public String getInventory(Model model){
        List<Inventory> inventoryList = serviceInventory.findInventory();
        model.addAttribute("inventoryList", inventoryList);
        return "pages/tables/inventory-stock";
    }

    @RequestMapping("/typesProductAndMeasure")
    public String getTypesProductsAndMeasure(Model model){
        List<MeasureUnit> measureUnits = serviceMeasureUnit.getMeasureUnit();
        List<WarehouseTypeProduct> warehouseTypeProducts = serviceWarehouseTypeProduct.warehouseTypeProductList();
        model.addAttribute("measureUnits", measureUnits);
        model.addAttribute("warehouseTypeProducts", warehouseTypeProducts);
        return "pages/tables/inventory-type-product-measure";
    }

}
