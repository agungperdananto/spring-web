package com.github.springweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.springweb.models.Order;
import com.github.springweb.services.OrderBusinessService;
import com.github.springweb.services.OrdersBusinessServiceInterface;


@Controller
@RequestMapping("/orders")
public class OrderController {

    // depedency injection
    // @Autowired
    // OrderBusinessService service;

    // depedency injection using constructor
    OrdersBusinessServiceInterface service;

    public OrderController(OrdersBusinessServiceInterface service) {
        super();
        this.service = service;
    }

    @GetMapping
    public String showAllOrders(Model model) {

        // generate orders

        // depedency - change later to depedency injection.
        // OrderBusinessService service = new OrderBusinessService();

       
        List<Order> orders = service.getOrders();
        model.addAttribute("title", "List of orders");
        model.addAttribute("orders", orders);

        return "orders.html";
    }
}
