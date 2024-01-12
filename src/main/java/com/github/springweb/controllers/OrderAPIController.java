package com.github.springweb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.springweb.models.Order;
import com.github.springweb.services.OrdersBusinessServiceInterface;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/orders")
public class OrderAPIController {
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
    public List<Order> showAllOrders() {

        // generate orders

        // depedency - change later to depedency injection.
        // OrderBusinessService service = new OrderBusinessService();

       
        List<Order> orders = service.getOrders();

        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable(name="id") long id) {
        Order order = service.getbyId(id);
        return order;
    }

    @DeleteMapping("/{id}")
    public boolean deleteOrder(@PathVariable(name="id") long id) {
       return service.deleteOrder(id);
    }

    @PutMapping("/{id}")
    public Order deleteOrder(@PathVariable(name="id") long id, @RequestBody Order updateOrder) {
       return service.updateOrder(id, updateOrder);
    }
    

    @GetMapping("/search/{keyword}")
    public List<Order> searchOrders(@PathVariable(name="keyword") String keyword) {

        // generate orders

        // depedency - change later to depedency injection.
        // OrderBusinessService service = new OrderBusinessService();

       
        List<Order> orders = service.searchOrders(keyword);

        return orders;
    }

    @PostMapping
    public Long createOrder(@RequestBody Order newOrder) {
        
        
        return service.createOrder(newOrder);
    }
    
}
