package com.github.springweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.springweb.models.Order;

@Service
public class OrderBusinessService2 implements OrdersBusinessServiceInterface{

    @Override
    public void test() {
        System.err.println("OrderBusineesService is working!");
    }

    @Override
    public List<Order> getOrders() {
        
        List<Order> orders = new ArrayList<Order>();

        orders.add(new Order(0L, "AAA", "Takoyaki", 12.0f, 3));
        orders.add(new Order(1L, "AAB", "Sushi", 18.54f, 5));
        orders.add(new Order(2L, "ABC", "Ramen", 16.5f, 2));
        orders.add(new Order(3L, "ADS", "Tonkotsu", 2.5f, 2));
        orders.add(new Order(4L, "ABR", "Tenpura don", 2.5f, 3));
        orders.add(new Order(5L, "ABV", "Onigiri", 1.7f, 4));
        orders.add(new Order(6L, "ADF", "Taiyaki", 1.5f, 3));
        orders.add(new Order(7L, "AFR", "yakiniku", 1.5f, 2));

        return orders;
    }

    @Override
    public Order getbyId(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getbyId'");
    }

    @Override
    public List<Order> searchOrders(String keyword) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchOrders'");
    }

    @Override
    public long createOrder(Order newOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createOrder'");
    }

    @Override
    public boolean deleteOrder(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOrder'");
    }

    @Override
    public Order updateOrder(long id, Order updateOrder) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrder'");
    }



}
