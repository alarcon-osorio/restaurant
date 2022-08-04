package com.restaurant.admin.controller.web;

import com.restaurant.admin.dto.MenuAccompanimentDTO;
import com.restaurant.admin.dto.MenuDTO;
import com.restaurant.admin.dto.MenuIncludesDTO;
import com.restaurant.admin.dto.MenuOptionalDTO;
import com.restaurant.admin.entity.*;
import com.restaurant.admin.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebMenu {

    @Autowired
    ServiceMenu serviceMenu;

    @Autowired
    ServiceMenuType serviceMenuType;

    @Autowired
    ServiceMenuAccompaniment serviceMenuAccompaniment;

    @Autowired
    ServiceMenuIncludes serviceMenuIncludes;

    @Autowired
    ServiceMenuOptional serviceMenuOptional;

    @GetMapping("/menu")
    public String getMenu(Model model){
        List<MenuDTO> menuList = serviceMenu.getMenu();
        model.addAttribute("menuList", menuList);
        return "pages/tables/menu-principal";
    }

    @GetMapping("/menuType")
    public String getMenuType(Model model){
        List<MenuType> menuTypeMenu = serviceMenuType.getMenuType();
        model.addAttribute("menuTypeMenu", menuTypeMenu);
        return "pages/tables/menu-type";
    }

    @GetMapping("/menuAccompaniment")
    public String getMenuAccompaniment(Model model){
        List<MenuAccompanimentDTO> menuAccompaniments = serviceMenuAccompaniment.getMenuAccompanimentList();
        model.addAttribute("menuAccompaniments", menuAccompaniments);
        return "pages/tables/menu-accompaniment";
    }

    @GetMapping("/menuIncludes")
    public String getMenuIncludes(Model model){
        List<MenuIncludesDTO> menuIncludes = serviceMenuIncludes.getMenuIncludes();
        model.addAttribute("menuIncludes", menuIncludes);
        return "pages/tables/menu-includes";
    }

    @GetMapping("/menuOptional")
    public String getMenuOptional(Model model){
        List<MenuOptionalDTO> menuOptionals = serviceMenuOptional.getMenuOptionals();
        model.addAttribute("menuOptionals", menuOptionals);
        return "pages/tables/menu-optional";
    }

}
