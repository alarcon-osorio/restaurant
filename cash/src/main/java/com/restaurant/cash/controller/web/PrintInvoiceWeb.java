package com.restaurant.cash.controller.web;

import com.restaurant.cash.entity.ServiceOrder;
import com.restaurant.cash.service.ServiceOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PrintInvoiceWeb {

    @Autowired
    ServiceOrders serviceOrders;

    @RequestMapping(value="/print_invoice")
    public String printInvoice(Model model, @RequestParam long table){
        List<ServiceOrder> serviceOrdersByTable = serviceOrders.getServiceOrdersByTable(table);
        model.addAttribute("serviceOrdersByTable", serviceOrdersByTable);
        String totalOrder = serviceOrders.getTotalOrder(table);
        model.addAttribute("table", table);
        model.addAttribute("totalOrder", totalOrder);
        return "viewPrintInvoice";
    }

}
