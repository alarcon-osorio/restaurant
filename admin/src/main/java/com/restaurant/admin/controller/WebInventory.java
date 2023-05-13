package com.restaurant.admin.controller;

import com.restaurant.admin.entity.Inventory;
import com.restaurant.admin.entity.MeasureUnit;
import com.restaurant.admin.entity.RestaurantTable;
import com.restaurant.admin.entity.WarehouseTypeProduct;
import com.restaurant.admin.service.ServiceInventory;
import com.restaurant.admin.service.ServiceMeasureUnit;
import com.restaurant.admin.service.ServiceWarehouseTypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
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


    @RequestMapping("/createInventory")
    public String createDiscount(Model model, Inventory inventory, @Nullable @RequestParam boolean create){
        List<MeasureUnit> measureUnits = serviceMeasureUnit.getMeasureUnit();
        List<WarehouseTypeProduct> warehouseTypeProducts = serviceWarehouseTypeProduct.warehouseTypeProductList();


        if (create){
            serviceInventory.saveInventory(inventory);
            return "redirect:/inventory?success";
        }

        model.addAttribute("measureUnits", measureUnits);
        model.addAttribute("warehouseTypeProducts", warehouseTypeProducts);
        return "pages/forms/inventory-form-create";
    }

    @RequestMapping("/editInventory")
    public String editDiscount(Model model, Inventory inventory, @Nullable @RequestParam boolean edit, @RequestParam long id){
        Inventory inventoryPrincipal = serviceInventory.findInventoryById(id);
        String idInventoryType = inventoryPrincipal.getType();
        String idMeasureUnit = inventoryPrincipal.getMeasureUnit();

        WarehouseTypeProduct warehouseTypeProduct = serviceWarehouseTypeProduct.warehouseTypeProductById(idInventoryType);
        MeasureUnit measureUnit = serviceMeasureUnit.getMeasureUnitById(Long.parseLong(idMeasureUnit));

        List<MeasureUnit> measureUnits = serviceMeasureUnit.getMeasureUnit();
        List<WarehouseTypeProduct> warehouseTypeProducts = serviceWarehouseTypeProduct.warehouseTypeProductList();

        if (edit){
            serviceInventory.saveInventory(inventory);
            return "redirect:/inventory?edit";
        }

        model.addAttribute("warehouseTypeProduct", warehouseTypeProduct);
        model.addAttribute("measureUnit", measureUnit);

        model.addAttribute("measureUnits", measureUnits);
        model.addAttribute("warehouseTypeProducts", warehouseTypeProducts);
        model.addAttribute("inventoryPrincipal", inventoryPrincipal);
        return "pages/forms/inventory-form-edit";
    }

    @RequestMapping("/deleteInventory")
    public String deleteDiscount(@RequestParam long id){
        serviceInventory.deleteInventory(id);
        return "redirect:/inventory?delete";
    }


    @RequestMapping("/typesProductAndMeasure")
    public String getTypesProductsAndMeasure(Model model){
        List<MeasureUnit> measureUnits = serviceMeasureUnit.getMeasureUnit();
        List<WarehouseTypeProduct> warehouseTypeProducts = serviceWarehouseTypeProduct.warehouseTypeProductList();
        model.addAttribute("measureUnits", measureUnits);
        model.addAttribute("warehouseTypeProducts", warehouseTypeProducts);
        return "pages/tables/inventory-type-product-measure";
    }

    @RequestMapping("/createTypesProduct")
    public String createTypesProduct(Model model, WarehouseTypeProduct warehouseTypeProduct, @Nullable @RequestParam boolean create){

        if (create){
            serviceWarehouseTypeProduct.saveWarehouseTypeProduct(warehouseTypeProduct);
            return "redirect:/typesProductAndMeasure?success";
        }

        return "pages/forms/inventory-type-form-create";
    }

    @RequestMapping("/editTypesProduct")
    public String editTypesProduct(Model model, WarehouseTypeProduct warehouseTypeProduct, @Nullable @RequestParam boolean edit, @RequestParam long id){
        WarehouseTypeProduct warehouseTypeProductPrincipal = serviceWarehouseTypeProduct.warehouseTypeProductById(String.valueOf(id));

        if (edit){
            serviceWarehouseTypeProduct.saveWarehouseTypeProduct(warehouseTypeProduct);
            return "redirect:/typesProductAndMeasure?edit";
        }

        model.addAttribute("warehouseTypeProductPrincipal", warehouseTypeProductPrincipal);
        return "pages/forms/inventory-type-form-edit";
    }

    @RequestMapping("/deleteTypesProduct")
    public String deleteTypesProduct(@RequestParam long id){
        serviceWarehouseTypeProduct.deleteWarehouseTypeProduct(id);
        return "redirect:/typesProductAndMeasure?delete";
    }

    @RequestMapping("/createMeasureUnits")
    public String createMeasureUnits(Model model, MeasureUnit measureUnit, @Nullable @RequestParam boolean create){

        if (create){
            serviceMeasureUnit.saveMeasureUnits(measureUnit);
            return "redirect:/typesProductAndMeasure?successUnits";
        }

        return "pages/forms/measure-units-form-create";
    }

    @RequestMapping("/editMeasureUnits")
    public String editMeasureUnits(Model model, MeasureUnit measureUnit, @Nullable @RequestParam boolean edit, @RequestParam long id){
        MeasureUnit measureUnitPrincipal = serviceMeasureUnit.getMeasureUnitById(id);

        if (edit){
            serviceMeasureUnit.saveMeasureUnits(measureUnit);
            return "redirect:/typesProductAndMeasure?editUnits";
        }

        model.addAttribute("measureUnitPrincipal", measureUnitPrincipal);
        return "pages/forms/measure-units-form-edit";
    }

    @RequestMapping("/deleteMeasureUnits")
    public String deleteMeasureUnits(@RequestParam long id){
        serviceMeasureUnit.deleteMeasureUnits(id);
        return "redirect:/typesProductAndMeasure?deleteUnits";
    }

}
