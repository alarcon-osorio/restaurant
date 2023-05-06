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
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    ServiceMenuPrice serviceMenuPrice;

    @GetMapping(value = "/accompaniment")
    public String accompaniment(Model model, @Nullable Long menuId, @Nullable Long menuIdPersonal, String table, boolean add, boolean edit) {

        if (menuId == null && edit == false) {
            //Se va por MenuPersonal para seleccionarlo
            log.info("MenuIdPersonal" + menuIdPersonal);
            MenuPersonal menuPersonal = serviceMenuPersonalView.getMenuPersonalById(menuIdPersonal);
            MenuPersonalForm optionsName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_options());
            MenuPersonalForm principlesName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_principles());
            MenuPersonalForm proteinsName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_proteins());
            MenuPersonalForm entriesName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_entries());
            MenuPersonalForm vegetablesName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_vegetables());
            MenuPersonalForm saladName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_salad());
            MenuPersonalForm drinksName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_drinks());
            MenuPrice price = serviceMenuPrice.getMenuPrice(1);
            List<RestaurantTable> listRestaurantTable = serviceRestaurantTable.getRestaurantTableList();

            if (add) {
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
            model.addAttribute("principlesName", principlesName.getName());
            model.addAttribute("proteins", menuPersonal.getMp_proteins());
            model.addAttribute("proteinsName", proteinsName.getName());
            model.addAttribute("entries", menuPersonal.getMp_entries());
            model.addAttribute("entriesName", entriesName.getName());
            model.addAttribute("vegetables", menuPersonal.getMp_vegetables());
            model.addAttribute("vegetablesName", vegetablesName.getName());
            model.addAttribute("salad", menuPersonal.getMp_salad());
            model.addAttribute("saladName", saladName.getName());
            model.addAttribute("drinks", menuPersonal.getMp_drinks());
            model.addAttribute("drinksName", drinksName.getName());
            model.addAttribute("observations", menuPersonal.getMp_observations());
            model.addAttribute("price", price.getValue());

            return "viewAccompanimentPersonal";

        } else if (menuId == null && edit == true) {
            //Se va por MenuPersonal para editarlo
            log.info("MenuIdPersonal" + menuIdPersonal);
            MenuPersonal menuPersonal = serviceMenuPersonalView.getMenuPersonalById(menuIdPersonal);
            MenuPersonalForm optionsName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_options());
            MenuPersonalForm principlesName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_principles());
            MenuPersonalForm proteinsName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_proteins());
            MenuPersonalForm entriesName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_entries());
            MenuPersonalForm vegetablesName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_vegetables());
            MenuPersonalForm saladName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_salad());
            MenuPersonalForm drinksName = serviceMenuPersonalForm.getMenuPersonalById(menuPersonal.getMp_drinks());
            MenuPrice price = serviceMenuPrice.getMenuPrice(1);
            List<RestaurantTable> listRestaurantTable = serviceRestaurantTable.getRestaurantTableList();

            List<MenuPersonalForm> menuPersonalFormOptions = serviceMenuPersonalForm.getMenuPersonalFormByType(1);
            List<MenuPersonalForm> menuPersonalFormPrinciples = serviceMenuPersonalForm.getMenuPersonalFormByType(2);
            List<MenuPersonalForm> menuPersonalFormProteins = serviceMenuPersonalForm.getMenuPersonalFormByType(3);
            List<MenuPersonalForm> menuPersonalFormEntries = serviceMenuPersonalForm.getMenuPersonalFormByType(4);
            List<MenuPersonalForm> menuPersonalFormVegetables = serviceMenuPersonalForm.getMenuPersonalFormByType(5);
            List<MenuPersonalForm> menuPersonalFormSalad = serviceMenuPersonalForm.getMenuPersonalFormByType(6);
            List<MenuPersonalForm> menuPersonalFormDrinks = serviceMenuPersonalForm.getMenuPersonalFormByType(7);

            model.addAttribute("listRestaurantTable", listRestaurantTable);
            model.addAttribute("menu_id", menuPersonal.getId());
            model.addAttribute("id_menuType", menuPersonal.getId_menu_type());
            model.addAttribute("menu_name", menuPersonal.getMp_name_dish());
            model.addAttribute("options", menuPersonal.getMp_options());
            model.addAttribute("optionsName", optionsName.getName());
            model.addAttribute("principles", menuPersonal.getMp_principles());
            model.addAttribute("principlesName", principlesName.getName());
            model.addAttribute("proteins", menuPersonal.getMp_proteins());
            model.addAttribute("proteinsName", proteinsName.getName());
            model.addAttribute("entries", menuPersonal.getMp_entries());
            model.addAttribute("entriesName", entriesName.getName());
            model.addAttribute("vegetables", menuPersonal.getMp_vegetables());
            model.addAttribute("vegetablesName", vegetablesName.getName());
            model.addAttribute("salad", menuPersonal.getMp_salad());
            model.addAttribute("saladName", saladName.getName());
            model.addAttribute("drinks", menuPersonal.getMp_drinks());
            model.addAttribute("drinksName", drinksName.getName());
            model.addAttribute("observations", menuPersonal.getMp_observations());
            model.addAttribute("price", price.getValue());


            model.addAttribute("menuPersonalFormOptions", menuPersonalFormOptions);
            model.addAttribute("menuPersonalFormPrinciples", menuPersonalFormPrinciples);
            model.addAttribute("menuPersonalFormProteins", menuPersonalFormProteins);
            model.addAttribute("menuPersonalFormEntries", menuPersonalFormEntries);
            model.addAttribute("menuPersonalFormVegetables", menuPersonalFormVegetables);
            model.addAttribute("menuPersonalFormSalad", menuPersonalFormSalad);
            model.addAttribute("menuPersonalFormDrinks", menuPersonalFormDrinks);
            model.addAttribute("menuPersonalView", "/menuPersonalView");

            return "viewEditAccompanimentPersonal";
        }

        List<MenuAccompaniment> menuAccompanimentList = serviceMenuAccompaniment.getMenuAccompanimentList();
        List<MenuAccompaniment> menuAccompanimentIdMenu = serviceMenuAccompaniment.getMenuAccompanimentMenuId(menuId);
        List<MenuIncludes> menuIncludeByIdMenu = serviceMenuIncludes.getMenuIncludesIdMenu(menuId);
        Menu menu = serviceMenu.getMenuId(menuId);
        List<RestaurantTable> listRestaurantTable = serviceRestaurantTable.getRestaurantTableList();
        List<MenuIncludes> menuIncludesList = serviceMenuIncludes.getMenuIncludesList();
        List<MenuOptional> menuOptionalList = serviceMenuOptional.getMenuOptionalByIdMenu(menuId);
        if (!menuIncludeByIdMenu.isEmpty()) {
            model.addAttribute("menuIncludes", "ok");
            model.addAttribute("menuIncludeByIdMenu", menuIncludeByIdMenu);
        }
        if (!menuAccompanimentIdMenu.isEmpty()) {
            model.addAttribute("menuAccompaniment", "ok");
            model.addAttribute("menuAccompanimentIdMenu", menuAccompanimentIdMenu);
        }
        if (!menuOptionalList.isEmpty()) {
            model.addAttribute("options", "ok");
            model.addAttribute("menuOptionalList", menuOptionalList);
        }
        if (add) {
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

    @GetMapping(value = "/deleteAccompaniment")
    public String deleteAccompaniment(Model model, @RequestParam Long menuIdPersonal, @RequestParam String username) {
        log.info("menuId " + menuIdPersonal + " username " + username );
        serviceMenuPersonalView.deleteMenuPersonal(menuIdPersonal);
        return "redirect:/menuPersonalView/" + username;
    }

    @RequestMapping(value = "/editAccompanimentPersonal")
    public String editAccompanimentPersonal(Model model, MenuPersonal menuPersonal){
        serviceMenuPersonalView.saveMenuPersonalView(menuPersonal);
        return "redirect:/accompaniment?menuIdPersonal=" +menuPersonal.getId() + "&edit=true&success";

    }

}