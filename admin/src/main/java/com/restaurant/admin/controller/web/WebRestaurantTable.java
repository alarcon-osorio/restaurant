package com.restaurant.admin.controller.web;

import com.restaurant.admin.entity.RestaurantTable;
import com.restaurant.admin.service.ServiceRestaurantTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
