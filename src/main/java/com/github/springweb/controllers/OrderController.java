package com.github.springweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.springweb.models.Order;
import com.github.springweb.models.Search;
import com.github.springweb.services.OrdersBusinessServiceInterface;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/orders")
public class OrderController {

    // depedency injection
    // @Autowired
    // OrderBusinessService service;

    // depedency injection using constructor
    @Autowired
    OrdersBusinessServiceInterface service;

    // public OrderController(OrdersBusinessServiceInterface service) {
    //     super();
    //     this.service = service;
    // }

    @GetMapping
    public String get(Model model) {

        // generate orders

        // depedency - change later to depedency injection.
        // OrderBusinessService service = new OrderBusinessService();

       
        List<Order> orders = service.getOrders();
        model.addAttribute("title", "List of orders");
        model.addAttribute("orders", orders);
        return "orders.html";
    }

    @PostMapping
    public String post(@Valid Order newOrder, BindingResult bindingResult, Model model){

        // add new data
        service.createOrder(newOrder);
        List<Order> orders = service.getOrders();

        model.addAttribute("orders", orders);

        return "orders";
    }

    @GetMapping("/create")
    public String createNewOrder(Model model) {

        model.addAttribute("order", new Order());
        return "newOrderForm.html";
    }
    
    @GetMapping("/search")
    public String searchPage(Model model) {
        model.addAttribute("searchModel", new Search());
        return "searchPage";
    }

    @PostMapping("/search")
    public String search(@Valid Search newSearch, BindingResult bindingResult, Model model) {
        List<Order> orders = service.searchOrders(newSearch.getKeyword());

        model.addAttribute("orders", orders);

        return "orders";
    }
    
}
