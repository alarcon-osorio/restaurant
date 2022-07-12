package com.restaurante.service.controller.web;

import com.restaurante.service.entity.ServiceOrder;
import com.restaurante.service.service.ServiceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class OrdersWeb {

    @Autowired
    ServiceOrders serviceOrders;

    @RequestMapping(value = "/orders")
    public String orders(Model model, long table){
        if (table == 0){
            List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrder();
            model.addAttribute("serviceOrderList", serviceOrderList);
            model.addAttribute("table", table);
            return "viewOrders";
        }
        try{
            List<ServiceOrder> serviceOrdersByTableNumber = serviceOrders.getByTableNumber(table);
            if (serviceOrdersByTableNumber.isEmpty()){
                model.addAttribute("table", table);
                model.addAttribute("empty", "empty");
                return "viewOrders";
            }
            model.addAttribute("tableNumber", serviceOrdersByTableNumber);
            model.addAttribute("table", table);
            return "viewOrders";
        }catch (NullPointerException ex){
            List<ServiceOrder> serviceOrderList = serviceOrders.getServiceOrder();
            model.addAttribute("serviceOrderList", serviceOrderList);
        }
        return "viewOrders";
    }


}
