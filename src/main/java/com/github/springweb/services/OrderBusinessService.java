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
    public Order getbyId(long id) {
        
        return ordersDAO.getbyId(id);
    }

    @Override
    public List<Order> searchOrders(String keyword) {
        return ordersDAO.searchOrders(keyword);
    }

    @Override
    public long createOrder(Order newOrder) {
       return ordersDAO.createOrder(newOrder);
    }

    @Override
    public boolean deleteOrder(long id) {
       return ordersDAO.deleteOrder(id);
    }

    @Override
    public Order updateOrder(long id, Order updateOrder) {
       return ordersDAO.updateOrder(id, updateOrder);
    }



}
