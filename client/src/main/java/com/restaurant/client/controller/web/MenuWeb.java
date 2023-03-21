package com.restaurant.client.controller.web;

import com.restaurant.client.entity.Menu;
import com.restaurant.client.entity.MenuType;
import com.restaurant.client.service.ServiceMenu;
import com.restaurant.client.service.ServiceMenuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MenuWeb {

    @Autowired
    ServiceMenu serviceMenu;

    @Autowired
    ServiceMenuType serviceMenuType;

    @GetMapping(value = "/menu")
    public String menu(Model model){
        List<Menu> menu = serviceMenu.getMenu();
        List<MenuType> menuTypeList = serviceMenuType.getMenuType();
        model.addAttribute("menu", menu);
        model.addAttribute("menuTypeList", menuTypeList);
        return "viewMenu";
    }

    @GetMapping(value = "/type_menu")
    public String typeMenu(Model model, long id){
        List<Menu> menu = serviceMenu.getMenuTypeId(id);
        List<MenuType> menuTypeList = serviceMenuType.getMenuType();
        model.addAttribute("menu", menu);
        model.addAttribute("menuTypeList", menuTypeList);
        return "viewMenu";
    }



}
