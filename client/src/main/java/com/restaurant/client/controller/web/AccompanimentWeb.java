package com.restaurant.client.controller.web;

import com.restaurant.client.entity.*;
import com.restaurant.client.entity.menu_personal.MenuPersonal;
import com.restaurant.client.entity.menu_personal.MenuPersonalForm;
import com.restaurant.client.service.*;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
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

    @Autowired
    ServiceMenuOptional serviceMenuOptional;

    @Autowired
    ServiceMenuPersonalView serviceMenuPersonalView;

    @Autowired
    ServiceMenuPersonalForm serviceMenuPersonalForm;

    @GetMapping(value = "/accompaniment")
    public String accompaniment(Model model, @Nullable Long menuId, @Nullable Long menuIdPersonal, String table, boolean add){

        if (menuId == null){
            //Se va por MenuPersonal
            log.info("MenuIdPersonal" + menuIdPersonal);
            MenuPersonal menuPersonal = serviceMenuPersonalView.getMenuPersonalById(menuIdPersonal);
            MenuPersonalForm optionsName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_options());
            log.info("----- " + optionsName);
            List<RestaurantTable> listRestaurantTable = serviceRestaurantTable.getRestaurantTableList();

            if(add){
                model.addAttribute("table", table);
                model.addAttribute("success", "ok");
            }

            model.addAttribute("listRestaurantTable", listRestaurantTable);
            model.addAttribute("menu_id", menuPersonal.getId());
            model.addAttribute("id_menuType", menuPersonal.getId_menu_type());
            model.addAttribute("menu_name", menuPersonal.getMp_name_dish());
            model.addAttribute("options", menuPersonal.getMp_options());
            model.addAttribute("optionsName", optionsName.getName());
            model.addAttribute("principles", menuPersonal.getMp_principles());
            model.addAttribute("proteins", menuPersonal.getMp_proteins());
            model.addAttribute("entries", menuPersonal.getMp_entries());
            model.addAttribute("vegetables", menuPersonal.getMp_vegetables());
            model.addAttribute("salad", menuPersonal.getMp_salad());
            model.addAttribute("drinks", menuPersonal.getMp_drinks());
            model.addAttribute("observations", menuPersonal.getMp_observations());

            return "viewAccompanimentPersonal";
        }

        List<MenuAccompaniment> menuAccompanimentList = serviceMenuAccompaniment.getMenuAccompanimentList();
        List<MenuAccompaniment> menuAccompanimentIdMenu = serviceMenuAccompaniment.getMenuAccompanimentMenuId(menuId);
        List<MenuIncludes> menuIncludeByIdMenu = serviceMenuIncludes.getMenuIncludesIdMenu(menuId);
        Menu menu = serviceMenu.getMenuId(menuId);
        List<RestaurantTable> listRestaurantTable = serviceRestaurantTable.getRestaurantTableList();
        List<MenuIncludes> menuIncludesList = serviceMenuIncludes.getMenuIncludesList();
        List<MenuOptional> menuOptionalList = serviceMenuOptional.getMenuOptionalByIdMenu(menuId);
        if  (!menuIncludeByIdMenu.isEmpty()){
            model.addAttribute("menuIncludes", "ok");
            model.addAttribute("menuIncludeByIdMenu", menuIncludeByIdMenu);
        }
        if  (!menuAccompanimentIdMenu.isEmpty()){
            model.addAttribute("menuAccompaniment", "ok");
            model.addAttribute("menuAccompanimentIdMenu", menuAccompanimentIdMenu);
        }
        if (!menuOptionalList.isEmpty()){
            model.addAttribute("options", "ok");
            model.addAttribute("menuOptionalList", menuOptionalList);
        }
        if(add){
            model.addAttribute("table", table);
            model.addAttribute("success", "ok");
        }
        model.addAttribute("menuName", menu.getName());
        model.addAttribute("menuDescription", menu.getDescription());
        model.addAttribute("menuImage", menu.getImage());
        model.addAttribute("menuTypeId", menu.getIdMenuType());
        model.addAttribute("menuPrice", menu.getPrice());
        model.addAttribute("menuId", menu.getId());
        model.addAttribute("listRestaurantTable", listRestaurantTable);
        model.addAttribute("menuIncludesList", menuIncludesList);
        return "viewAccompaniment";
    }


}
