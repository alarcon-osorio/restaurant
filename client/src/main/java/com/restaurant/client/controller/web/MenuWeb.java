package com.restaurant.client.controller.web;

import com.restaurant.client.entity.*;
import com.restaurant.client.dto.MenuPersonalDTO;
import com.restaurant.client.entity.menu_personal.MenuPersonal;
import com.restaurant.client.entity.menu_personal.MenuPersonalForm;
import com.restaurant.client.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
public class MenuWeb {

    @Autowired
    public ServiceMenu serviceMenu;

    @Autowired
    public ServiceMenuType serviceMenuType;

    @Autowired
    public ServiceOrders serviceOrders;

    @Autowired
    public ServiceMenuAccompaniment serviceMenuAccompaniment;

    @Autowired
    public ServiceMenuIncludes serviceMenuIncludes;

    @Autowired
    public ServiceMenuOptional serviceMenuOptional;

    @Autowired
    public ServiceMenuPersonalForm serviceMenuPersonalForm;

    @Autowired
    public ServiceMenuPersonalView serviceMenuPersonalView;

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

    @GetMapping(value = "/menuPersonalForm")
    public String menuPersonal(Model model, boolean edit){
        List<MenuType> menuTypeList = serviceMenuType.getMenuType();
        List<MenuPersonalForm> menuPersonalFormOptions = serviceMenuPersonalForm.getMenuPersonalFormByType(1);
        List<MenuPersonalForm> menuPersonalFormPrinciples = serviceMenuPersonalForm.getMenuPersonalFormByType(2);
        List<MenuPersonalForm> menuPersonalFormProteins = serviceMenuPersonalForm.getMenuPersonalFormByType(3);
        List<MenuPersonalForm> menuPersonalFormEntries = serviceMenuPersonalForm.getMenuPersonalFormByType(4);
        List<MenuPersonalForm> menuPersonalFormVegetables = serviceMenuPersonalForm.getMenuPersonalFormByType(5);
        List<MenuPersonalForm> menuPersonalFormSalad = serviceMenuPersonalForm.getMenuPersonalFormByType(6);
        List<MenuPersonalForm> menuPersonalFormDrinks = serviceMenuPersonalForm.getMenuPersonalFormByType(7);
        if (edit) {
            model.addAttribute("success", "ok");
        }
        model.addAttribute("menuTypeList", menuTypeList);
        model.addAttribute("menuPersonalFormOptions", menuPersonalFormOptions);
        model.addAttribute("menuPersonalFormPrinciples", menuPersonalFormPrinciples);
        model.addAttribute("menuPersonalFormProteins", menuPersonalFormProteins);
        model.addAttribute("menuPersonalFormEntries", menuPersonalFormEntries);
        model.addAttribute("menuPersonalFormVegetables", menuPersonalFormVegetables);
        model.addAttribute("menuPersonalFormSalad", menuPersonalFormSalad);
        model.addAttribute("menuPersonalFormDrinks", menuPersonalFormDrinks);
        return "menuPersonalForm";
    }

    @PostMapping(value = "/menuPersonalSave")
    public String SavePersonalMenu(Model model, MenuPersonal menuPersonal){
        if (menuPersonal.getMp_observations().isEmpty()){
            menuPersonal.setMp_observations("Sin Observaciones");
        }
        serviceMenuPersonalView.saveMenuPersonalView(menuPersonal);
        return "redirect:/menuPersonalView/" + menuPersonal.getUsername() + "?success";
    }

    @GetMapping(value = "/menuPersonalView/{username}")
    public String menuPersonalView(Model model, @PathVariable String username){
        List<MenuPersonal> menuPersonal = serviceMenuPersonalView.getMenuPersonalByUsername(username);

        if (menuPersonal.isEmpty()){
            model.addAttribute("withOutMenuPersonal", "ok");
        }

        List<MenuPersonalDTO> menuPersonalListByName = serviceMenuPersonalView.getMenuPersonalByNameAndUsername(username);

        model.addAttribute("menuPersonal", menuPersonal);
        model.addAttribute("menuPersonalListByName", menuPersonalListByName);
        return "menuPersonalView";
    }


}
