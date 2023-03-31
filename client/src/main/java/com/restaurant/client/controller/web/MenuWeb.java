package com.restaurant.client.controller.web;

import com.restaurant.client.entity.*;
import com.restaurant.client.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MenuWeb {

    @Autowired
    ServiceMenu serviceMenu;

    @Autowired
    ServiceMenuType serviceMenuType;

    @Autowired
    ServiceOrders serviceOrders;

    @Autowired
    ServiceMenuAccompaniment serviceMenuAccompaniment;

    @Autowired
    ServiceMenuIncludes serviceMenuIncludes;

    @Autowired
    ServiceMenuOptional serviceMenuOptional;

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

    @GetMapping(value = "/menuPersonal")
    public String menuPersonal(Model model, boolean edit){
        List<MenuAccompaniment> menuAccompaniment = serviceMenuAccompaniment.getMenuAccompanimentList();
        List<MenuIncludes> menuIncludesList = serviceMenuIncludes.getMenuIncludesList();
        List<MenuOptional> menuOptionalList = serviceMenuOptional.getMenuOptional();
        List<String> menuAccompanimentDistinct = serviceMenuAccompaniment.getMenuAccompanimentDistinct();
        if (edit) {
            model.addAttribute("success", "ok");
        }
        model.addAttribute("menuAccompaniment", menuAccompaniment);
        model.addAttribute("menuIncludesList", menuIncludesList);
        model.addAttribute("menuOptionalList", menuOptionalList);
        model.addAttribute("menuAccompanimentDistinct", menuAccompanimentDistinct);
        return "viewMenuPersonal";
    }

    @PostMapping(value = "/save_personal_menu")
    public String SavePersonalMenu(Model model){
        return "redirect:/viewMenuPersonal";
    }


}
