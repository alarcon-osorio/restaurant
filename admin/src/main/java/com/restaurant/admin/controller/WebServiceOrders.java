package com.restaurant.admin.controller;

import com.restaurant.admin.entity.ServiceOrder;
import com.restaurant.admin.service.ServiceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebServiceOrders {

    @Autowired
    ServiceOrders serviceOrders;

    @RequestMapping("/serviceOrders")
    public String getServiceOrders(Model model){
        List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrders();
        model.addAttribute("serviceOrderList", serviceOrderList);
        return "pages/tables/service-orders";
    }

}
