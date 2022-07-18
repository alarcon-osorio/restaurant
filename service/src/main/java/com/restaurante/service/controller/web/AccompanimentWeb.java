package com.restaurante.service.controller.web;

import com.restaurante.service.entity.*;
import com.restaurante.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @Autowired
    ServiceMenuOptional serviceMenuOptional;

    @Autowired
    ServiceOrders serviceOrders;

    @GetMapping(value = "/accompaniment")
    public String accompaniment(Model model, long menuId, String table, boolean add){
        List<MenuAccompaniment> menuAccompaniment = serviceMenuAccompaniment.getMenuAccompanimentList();
        Menu menu = serviceMenu.getMenuId(menuId);
        List<RestaurantTable> listRestaurantTable = serviceRestaurantTable.getRestaurantTableList();
        List<MenuIncludes> menuIncludesList = serviceMenuIncludes.getMenuIncludesList();
        List<MenuOptional> menuOptionalList = serviceMenuOptional.getMenuOptionalByIdMenu(menuId);
        if (!menuOptionalList.isEmpty()){
            model.addAttribute("options", "ok");
            model.addAttribute("menuOptionalList", menuOptionalList);
        }
        if(add){
            model.addAttribute("table", table);
            model.addAttribute("success", "ok");
        }
        model.addAttribute("menuAccompaniment", menuAccompaniment);
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

    @RequestMapping(value = "/saveOrder")
    public String saveOrder(ServiceOrder serviceOrder){
        serviceOrders.saveOrder(serviceOrder);
        return "redirect:/accompaniment?menuId=" + serviceOrder.getIdMenu() + "&table=" + serviceOrder.getTableNumber() + "&add=true";
    }

    //TODO: Que traiga el id_menu_type para diferenciar los platos especiales y poder personalizarlos
    //TODO: Intentar hacer un contador de 0 valores para con th:if para que no muestra campos que no sean necesios

}
