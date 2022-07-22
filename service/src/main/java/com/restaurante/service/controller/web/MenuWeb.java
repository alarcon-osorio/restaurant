package com.restaurante.service.controller.web;

import com.restaurante.service.entity.Menu;
import com.restaurante.service.entity.MenuType;
import com.restaurante.service.service.ServiceMenu;
import com.restaurante.service.service.ServiceMenuType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
