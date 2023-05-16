package com.restaurant.admin.controller;

import com.restaurant.admin.entity.Discount;
import com.restaurant.admin.entity.PaymentMethod;
import com.restaurant.admin.service.ServiceDiscount;
import com.restaurant.admin.service.ServicePaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class WebPaymentDiscount {

    @Autowired
    ServiceDiscount serviceDiscount;

    @Autowired
    ServicePaymentMethod servicePaymentMethod;

    @GetMapping("paymentDiscount")
    public String getPaymentDiscount(Model model){
        List<PaymentMethod> paymentMethodList = servicePaymentMethod.getPaymentMethod();
        List<Discount> discountList = serviceDiscount.getDiscount();
        model.addAttribute("paymentMethodList", paymentMethodList);
        model.addAttribute("discountList", discountList);
        return "pages/tables/payment-discount";
    }

    @RequestMapping("/createPaymentMethod")
    public String createPaymentMethod(Model model, PaymentMethod paymentMethod, @Nullable @RequestParam boolean create){

        if (create){
            servicePaymentMethod.savePaymentMethod(paymentMethod);
            return "redirect:/paymentDiscount?success";
        }

        return "pages/forms/payment-method-form-create";
    }

    @RequestMapping("/editPaymentMethod")
    public String editPaymentMethod(Model model, PaymentMethod paymentMethod, @Nullable @RequestParam boolean edit, @RequestParam long id){
        PaymentMethod paymentMethodPrincipal = servicePaymentMethod.getPaymentMethodById(id);
        if (edit){
            servicePaymentMethod.savePaymentMethod(paymentMethod);
            return "redirect:/paymentDiscount?edit";
        }
        model.addAttribute("paymentMethodPrincipal", paymentMethodPrincipal);
        return "pages/forms/payment-method-form-edit";
    }

    @RequestMapping("/deletePaymentMethod")
    public String deletePaymentMethod(@RequestParam long id){
        servicePaymentMethod.deletePaymentMethod(id);
        return "redirect:/paymentDiscount?delete";
    }

    @RequestMapping("/createDiscount")
    public String createDiscount(Model model, Discount discount, @Nullable @RequestParam boolean create){

        if (create){
            serviceDiscount.saveDiscount(discount);
            return "redirect:/paymentDiscount?successDiscount";
        }

        return "pages/forms/discount-form-create";
    }

    @RequestMapping("/editDiscount")
    public String editDiscount(Model model, Discount discount, @Nullable @RequestParam boolean edit, @RequestParam long id){
        Discount discountPrincipal = serviceDiscount.getDiscountById(id);

        if (edit){
            serviceDiscount.saveDiscount(discount);
            return "redirect:/paymentDiscount?editDiscount";
        }
        model.addAttribute("discountPrincipal", discountPrincipal);
        return "pages/forms/discount-form-edit";
    }

    @RequestMapping("/deleteDiscount")
    public String deleteDiscount(@RequestParam long id){
        serviceDiscount.deleteDiscount(id);
        return "redirect:/paymentDiscount?deleteDiscount";
    }


}
