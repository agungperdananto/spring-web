package com.github.springweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.github.springweb.models.Order;

@Service
@Primary
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



}
