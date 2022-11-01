package com.buimanhthanh.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buimanhthanh.dto.OrderDTO;
import com.buimanhthanh.entity.Order;
import com.buimanhthanh.service.OrderService;

@Controller
@RequestMapping("/admin")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/order")
    public String order(ModelMap model) {
        model.addAttribute("model", Order.class.getSimpleName());
        System.out.println(Order.class.getSimpleName());
        model.addAttribute("listObject", orderService.getAllOrder().get());
        return "adminTable";
    }

//    @GetMapping("/order/detail/{id}")
//    public String orderDetail(ModelMap model, @PathVariable(required = true, name = "id") Integer id) {
//        model.addAttribute("model", OrderDetail.class.getSimpleName());
//        orderService.getOrderById(id).ifPresentOrElse(o -> model.addAttribute("listObject", o.getOrderDetailsById()),
//                () -> model.addAttribute("listObject", new ArrayList<OrderDetail>()));
//        return "adminTable";
//    }

    @PostMapping("/order")
    public String order(ModelMap model, @ModelAttribute("discountCode") @Valid OrderDTO order, BindingResult result) {
        if (result.hasErrors())
            return "adminTable";
        else {
            orderService.saveOrUpdateOrder(order);
            return "redirect:/order";
        }
    }

}
