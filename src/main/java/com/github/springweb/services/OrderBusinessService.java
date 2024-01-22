package com.github.springweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.github.springweb.data.OrderDataAccessInterface;
import com.github.springweb.models.Order;

import lombok.extern.slf4j.Slf4j;


@Service
@Primary
@Slf4j
@RequestScope
public class OrderBusinessService implements OrdersBusinessServiceInterface{

    @Autowired
    OrderDataAccessInterface<Order> ordersDAO;

    @Override
    public void test() {
        log.info("OrderBusinessService is running.");
    }

    @Override
    public List<Order> getOrders() {

        return ordersDAO.getOrders();
    }

    @Override
    public Order getbyId(String id) {
        
        return ordersDAO.getbyId(id);
    }

    @Override
    public List<Order> searchOrders(String keyword) {
        return ordersDAO.searchOrders(keyword);
    }

    @Override
    public String createOrder(Order newOrder) {
       return ordersDAO.createOrder(newOrder);
    }

    @Override
    public boolean deleteOrder(String id) {
       return ordersDAO.deleteOrder(id);
    }

    @Override
    public Order updateOrder(String id, Order updateOrder) {
       return ordersDAO.updateOrder(id, updateOrder);
    }



}
