package com.restaurant.kitchen.controller.web;

import com.restaurant.kitchen.entity.ServiceOrder;
import com.restaurant.kitchen.service.ServiceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrdersWeb {

    @Autowired
    ServiceOrders serviceOrders;

    @RequestMapping(value = "/cocina")
    public String getServiceOrderAll(Model model){
        List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrderList();
        model.addAttribute("serviceOrderList", serviceOrderList);
        return "ordersView";
    }

}
