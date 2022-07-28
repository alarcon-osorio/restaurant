package com.restaurant.warehouse.controller.web;

import com.restaurant.warehouse.entity.Inventory;
import com.restaurant.warehouse.service.ServiceInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class WebInventory {

    @Autowired
    ServiceInventory serviceInventory;

    @RequestMapping("/inventory")
    public String getInventory(Model model){
        List<Inventory> inventoryList = serviceInventory.findInventory();
        model.addAttribute("inventoryList", inventoryList);
        return "viewInventory";
    }

    @RequestMapping("/add_inventory")
    public String addInventory(Model model, String operation){
        if (Objects.equals(operation, "add")){
            model.addAttribute("add", "ok");
        }
        model.addAttribute("inventoryById", new Inventory());
        return "viewInventoryForm";
    }

    @GetMapping("/edit_inventory")
    public String editInventory(Model model, @RequestParam long id, boolean update){
       Inventory inventoryById = serviceInventory.findInventoryById(id);
       if (update){
         model.addAttribute("update","ok");
       }
       model.addAttribute("enableBtDelete", "ok");
       model.addAttribute("inventoryById", inventoryById);
       return "viewInventoryForm";
    }

    @PostMapping("/save_inventory")
    public String saveInventory(Model model, Inventory inventory, String operation){
        Date now = new Date();
        inventory.setDate(String.valueOf(now));
        serviceInventory.saveInventory(inventory);
        if (Objects.equals(operation, "update")) {
            return "redirect:/edit_inventory?id=" + inventory.getId() + "&update=true";
        }
        return "redirect:/add_inventory?operation=" + operation;
    }

    @RequestMapping("/delete_inventory")
    public String saveInventory(Model model, long id){
        serviceInventory.deleteInventory(id);
        return "redirect:/inventory";
    }

}
