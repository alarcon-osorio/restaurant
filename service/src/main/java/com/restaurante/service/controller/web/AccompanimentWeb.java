package com.restaurante.service.controller.web;

import com.restaurante.service.entity.Menu;
import com.restaurante.service.entity.MenuAccompaniment;
import com.restaurante.service.entity.MenuIncludes;
import com.restaurante.service.entity.RestaurantTable;
import com.restaurante.service.service.ServiceMenu;
import com.restaurante.service.service.ServiceMenuAccompaniment;
import com.restaurante.service.service.ServiceMenuIncludes;
import com.restaurante.service.service.ServiceRestaurantTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccompanimentWeb {

    @Autowired
    ServiceMenu serviceMenu;

    @Autowired
    ServiceMenuAccompaniment serviceMenuAccompaniment;

    @Autowired
    ServiceRestaurantTable serviceRestaurantTable;

    @Autowired
    ServiceMenuIncludes serviceMenuIncludes;

    @GetMapping(value = "/accompaniment")
    public String accompaniment(Model model, long menuId){
        List<MenuAccompaniment> menuAccompaniment = serviceMenuAccompaniment.getMenuAccompanimentList();
        Menu menu = serviceMenu.getMenuId(menuId);
        List<RestaurantTable> listRestaurantTable = serviceRestaurantTable.getRestaurantTableList();
        List<MenuIncludes> menuIncludesList = serviceMenuIncludes.getMenuIncludesList();
        model.addAttribute("menuAccompaniment", menuAccompaniment);
        model.addAttribute("menuName", menu.getName());
        model.addAttribute("menuDescription", menu.getDescription());
        model.addAttribute("menuImage", menu.getImage());
        model.addAttribute("menuTypeId", menu.getIdMenuType());
        model.addAttribute("menud", menu.getId());
        model.addAttribute("listRestaurantTable", listRestaurantTable);
        model.addAttribute("menuIncludesList", menuIncludesList);
        return "viewAccompaniment";
    }

}
