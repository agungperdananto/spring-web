package com.github.springweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.springweb.models.Order;
import com.github.springweb.models.Search;
import com.github.springweb.services.OrdersBusinessServiceInterface;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;




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

    @PostMapping("/update")
    public String put( @Valid Order order, BindingResult bindingResult, Model model) {

        service.updateOrder(order.getId(), order);

        List<Order> orders = service.getOrders();

        model.addAttribute("orders", orders);
        
        return "ordersAdmin";
    }

    @PostMapping("/delete")
    public String delete( @Valid Order order, BindingResult bindingResult, Model model) {

        service.deleteOrder(order.getId());

        List<Order> orders = service.getOrders();

        model.addAttribute("orders", orders);
        
        return "ordersAdmin";
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
    
    @GetMapping("/admin")
    public String getAdmin(Model model) {

        // generate orders

        // depedency - change later to depedency injection.
        // OrderBusinessService service = new OrderBusinessService();

       
        List<Order> orders = service.getOrders();
        model.addAttribute("orders", orders);
        return "ordersAdmin";
    }

    

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable(name="id") String id, @ModelAttribute("loginModel") Order order, Model model) {
        
        order = service.getbyId(id);
        model.addAttribute("order", order);
        
        return "editForm";
    }
}
