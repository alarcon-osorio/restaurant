package com.restaurant.warehouse.controller.web;

import com.restaurant.warehouse.entity.Inventory;
import com.restaurant.warehouse.entity.MeasureUnit;
import com.restaurant.warehouse.entity.WarehouseTypeProduct;
import com.restaurant.warehouse.service.ServiceInventory;
import com.restaurant.warehouse.service.ServiceMeasureUnit;
import com.restaurant.warehouse.service.ServiceWarehouseTypeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Controller
public class WebInventory {

    @Autowired
    ServiceInventory serviceInventory;

    @Autowired
    ServiceMeasureUnit serviceMeasureUnit;

    @Autowired
    ServiceWarehouseTypeProduct serviceWarehouseTypeProduct;

    @RequestMapping("/inventory")
    public String getInventory(Model model, String operation){
        try{
            if (operation.equals("add")){
                model.addAttribute("add", "ok");
            }
            if (operation.equals("update")){
                model.addAttribute("update", "ok");
            }
            List<Inventory> inventoryList = serviceInventory.findInventory();
            model.addAttribute("inventoryList", inventoryList);
            return "viewInventory";
        }catch (NullPointerException ex){
            List<Inventory> inventoryList = serviceInventory.findInventory();
            model.addAttribute("inventoryList", inventoryList);
            return "viewInventory";
        }

    }

    @RequestMapping("/add_inventory")
    public String addInventory(Model model, String operation){
        if (Objects.equals(operation, "add")){
            model.addAttribute("add", "ok");
        }
        List<MeasureUnit> getMeasureUnitList = serviceMeasureUnit.getMeasureUnit();
        List<WarehouseTypeProduct> warehouseTypeProductList = serviceWarehouseTypeProduct.warehouseTypeProductList();
        model.addAttribute("warehouseTypeProductList", warehouseTypeProductList);
        model.addAttribute("getMeasureUnitList", getMeasureUnitList);
        model.addAttribute("inventoryById", new Inventory());
        return "viewInventoryForm";
    }

    @GetMapping("/edit_inventory")
    public String editInventory(Model model, @RequestParam long id, boolean update){
       Inventory inventoryById = serviceInventory.findInventoryById(id);
       if (update){
         model.addAttribute("update","ok");
       }
       List<MeasureUnit> getMeasureUnitList = serviceMeasureUnit.getMeasureUnit();
       List<WarehouseTypeProduct> warehouseTypeProductList = serviceWarehouseTypeProduct.warehouseTypeProductList();
       model.addAttribute("warehouseTypeProductList", warehouseTypeProductList);
       model.addAttribute("getMeasureUnitList", getMeasureUnitList);
       model.addAttribute("enableBtDelete", "ok");
       model.addAttribute("inventoryById", inventoryById);
       return "viewInventoryForm";
    }

    @PostMapping("/save_inventory")
    public String saveInventory(Model model, Inventory inventory, String operation){
        Date now = new Date();
        inventory.setDate(String.valueOf(now));
        String typeProductToUpperCase = inventory.getType().toUpperCase();
        String numberProductLetter = typeProductToUpperCase.substring(0, 2);
        String inventoryNumberProduct = serviceInventory.findNumberProduct(numberProductLetter);
        String numberProductNumber = inventoryNumberProduct.substring(2, inventoryNumberProduct.length());

        if (operation.equals("add")) {
            if (Long.parseLong(numberProductNumber) >= 10 && Long.parseLong(numberProductNumber) <= 98){
                long addition = Long.parseLong(numberProductNumber);
                long numberProduct = addition + 1;
                String complete = "0" + numberProduct;
                inventory.setNumberProduct(numberProductLetter + complete);
            }else if(Long.parseLong(numberProductNumber) >= 99){
                long addition = Long.parseLong(numberProductNumber);
                long numberProduct = addition + 1;
                inventory.setNumberProduct(numberProductLetter + numberProduct);
            }else{
                long addition = Long.parseLong(numberProductNumber);
                long numberProduct = addition + 1;
                String complete = "00" + numberProduct;
                inventory.setNumberProduct(numberProductLetter + complete);
            }
        }

        serviceInventory.saveInventory(inventory);

        if (Objects.equals(operation, "update")) {
            return "redirect:/inventory?operation=" + operation;
        }

        return "redirect:/inventory?operation=" + operation;
    }

    @RequestMapping("/delete_inventory")
    public String saveInventory(Model model, long id){
        serviceInventory.deleteInventory(id);
        return "redirect:/inventory";
    }

}
