package com.restaurant.admin.controller;

import com.restaurant.admin.dto.MenuPersonalTypeDTO;
import com.restaurant.admin.entity.*;
import com.restaurant.admin.service.ServiceMenu;
import com.restaurant.admin.service.ServiceMenuPersonalType;
import com.restaurant.admin.service.ServiceMenuType;
import com.restaurant.admin.service.ServiceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebServiceOrders {

    @Autowired
    ServiceOrders serviceOrders;

    @Autowired
    ServiceMenuPersonalType serviceMenuPersonalType;

    @Autowired
    ServiceMenu serviceMenu;

    @Autowired
    ServiceMenuType serviceMenuType;

    @RequestMapping("/serviceOrders")
    public String getServiceOrders(Model model){
        List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrders();
        model.addAttribute("serviceOrderList", serviceOrderList);
        return "pages/tables/service-orders";
    }

    @RequestMapping("/createServiceOrders")
    public String createServiceOrders(Model model, ServiceOrder serviceOrder, @Nullable @RequestParam boolean create){
        List<MenuPersonalType> menuPersonalTypeList = serviceMenuPersonalType.getMenuType();

        if (create){
            serviceOrders.saveServerOrders(serviceOrder);
            return "redirect:/serviceOrders?success";
        }

        model.addAttribute("menuPersonalTypeList", menuPersonalTypeList);
        return "pages/forms/service-orders-form-create";
    }

    @RequestMapping("/editServiceOrders")
    public String editServiceOrders(Model model, ServiceOrder serviceOrder, @Nullable @RequestParam boolean edit, @RequestParam long id){
        ServiceOrder serviceOrderPrincipal = serviceOrders.getServiceOrdersById(id);
        long menuId = serviceOrderPrincipal.getIdMenu();
        long menuTypeId = serviceOrderPrincipal.getIdMenuType();
        MenuType menuType = serviceMenuType.getMenuTypeId(menuTypeId);

        try{
            Menu menu = serviceMenu.getMenuId(menuId);
            model.addAttribute("menu", menu);
        }catch (Exception exception){

        }

        if (edit){
            serviceOrders.saveServerOrders(serviceOrder);
            return "redirect:/serviceOrders?success";
        }

        model.addAttribute("serviceOrderPrincipal", serviceOrderPrincipal);
        model.addAttribute("menuType", menuType);

        return "pages/forms/service-orders-form-edit";
    }




}
