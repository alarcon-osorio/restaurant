package com.restaurante.service.controller.web;

import com.restaurante.service.dto.MenuPersonalDTO;
import com.restaurante.service.entity.Menu;
import com.restaurante.service.entity.MenuPersonal;
import com.restaurante.service.entity.MenuType;
import com.restaurante.service.service.ServiceMenu;
import com.restaurante.service.service.ServiceMenuPersonalView;
import com.restaurante.service.service.ServiceMenuType;
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

    @Autowired
    ServiceMenuPersonalView serviceMenuPersonalView;

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

    @GetMapping(value = "/menuPersonalView")
    public String menuPersonalView(Model model){
        List<MenuPersonal> menuPersonal = serviceMenuPersonalView.getMenuPersonalList();

        if (menuPersonal.isEmpty()){
            model.addAttribute("withOutMenuPersonal", "ok");
        }

        List<MenuPersonalDTO> menuPersonalListByName = serviceMenuPersonalView.getMenuPersonaDTOlList();

        model.addAttribute("menuPersonal", menuPersonal);
        model.addAttribute("menuPersonalListByName", menuPersonalListByName);
        return "menuPersonalView";
    }



}
