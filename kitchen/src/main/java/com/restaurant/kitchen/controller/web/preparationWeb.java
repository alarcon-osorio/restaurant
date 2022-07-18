package com.restaurant.kitchen.controller.web;

import com.restaurant.kitchen.entity.MenuAccompaniment;
import com.restaurant.kitchen.entity.ServiceOrder;
import com.restaurant.kitchen.service.ServiceMenuAccompaniment;
import com.restaurant.kitchen.service.ServiceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class preparationWeb {

    @Autowired
    ServiceOrders serviceOrders;

    @Autowired
    ServiceMenuAccompaniment serviceMenuAccompaniment;

    @RequestMapping(value="/preparation")
    public String getServiceOrderId(Model model, long id){
        List<MenuAccompaniment> menuAccompaniments = serviceMenuAccompaniment.getMenuAccompaniment();
        ServiceOrder serviceOrderById = serviceOrders.getServiceOrderById(id);
        System.out.println("model = " + serviceOrderById);
        model.addAttribute("serviceOrderById", serviceOrderById);
        model.addAttribute("menuAccompaniments", menuAccompaniments);
        return "preparationView";
    }

}
