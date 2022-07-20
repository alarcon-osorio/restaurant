package com.restaurant.cash.controller.web;

import com.restaurant.cash.entity.PaymentMethod;
import com.restaurant.cash.entity.ServiceOrder;
import com.restaurant.cash.service.ServiceOrders;
import com.restaurant.cash.service.ServicePaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CashWeb {

    @Autowired
    ServiceOrders serviceOrders;

    @Autowired
    ServicePaymentMethod servicePaymentMethod;

    @RequestMapping(value = "/cash_register")
    public String getServiceOrders(Model model, long table){
        List<String> tableDistinct = serviceOrders.getTableNumberDistinct();
        List<ServiceOrder> serviceOrdersByTable = serviceOrders.getServiceOrdersByTable(table);
        if (serviceOrdersByTable.isEmpty()){
            model.addAttribute("nonCash", "ok");
        }
        String totalOrder = serviceOrders.getTotalOrder(table);
        List<PaymentMethod> paymentMethods = servicePaymentMethod.getPaymentMethod();
        model.addAttribute("totalOrder", totalOrder);
        model.addAttribute("paymentMethods", paymentMethods);
        model.addAttribute("tableDistinct", tableDistinct);
        model.addAttribute("serviceOrdersByTable", serviceOrdersByTable);
        model.addAttribute("table", table);
        return "viewCash";
    }

    @RequestMapping(value = "/close_cash")
    public String closeCash(Model model, String method, long table){
        servicePaymentMethod.savePaymentMethod(method, table);
        return "redirect:/cash_register?table=0";
    }
}