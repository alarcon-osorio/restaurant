package com.restaurante.service.controller.web;

import com.restaurante.service.entity.ServiceOrder;
import com.restaurante.service.service.ServiceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderWeb {

    @Autowired
    ServiceOrders serviceOrders;

    @RequestMapping(value = "/saveOrder")
    public String saveOrder(ServiceOrder serviceOrder){
        serviceOrders.saveOrder(serviceOrder);
        return "redirect:/accompaniment?menuId=" + serviceOrder.getIdMenu() + "&add=true";
    }

}
