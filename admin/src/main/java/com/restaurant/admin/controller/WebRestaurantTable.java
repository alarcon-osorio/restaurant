package com.restaurant.admin.controller;

import com.restaurant.admin.entity.Discount;
import com.restaurant.admin.entity.RestaurantTable;
import com.restaurant.admin.service.ServiceRestaurantTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebRestaurantTable {

    @Autowired
    ServiceRestaurantTable serviceRestaurantTable;

    @RequestMapping("restaurantTable")
    public String getRestaurantTable(Model model){
        List<RestaurantTable> restaurantTableList = serviceRestaurantTable.getRestaurantTableList();
        model.addAttribute("restaurantTableList", restaurantTableList);
        return "pages/tables/restaurant-table";
    }

    @RequestMapping("/createRestaurantTable")
    public String createDiscount(Model model, RestaurantTable restaurantTable, @Nullable @RequestParam boolean create){

        if (create){
            serviceRestaurantTable.saveRestaurantTable(restaurantTable);
            return "redirect:/restaurantTable?success";
        }

        return "pages/forms/table-form-create";
    }

    @RequestMapping("/editRestaurantTable")
    public String editDiscount(Model model, RestaurantTable restaurantTable, @Nullable @RequestParam boolean edit, @RequestParam long id){
        RestaurantTable restaurantTablePrincipal = serviceRestaurantTable.getRestaurantTableById(id);

        if (edit){
            serviceRestaurantTable.saveRestaurantTable(restaurantTable);
            return "redirect:/restaurantTable?edit";
        }
        model.addAttribute("restaurantTablePrincipal", restaurantTablePrincipal);
        return "pages/forms/table-form-edit";
    }

    @RequestMapping("/deleteRestaurantTable")
    public String deleteDiscount(@RequestParam long id){
        serviceRestaurantTable.deleteRestaurantTable(id);
        return "redirect:/restaurantTable?delete";
    }


}
