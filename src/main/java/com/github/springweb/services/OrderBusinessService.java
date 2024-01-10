package com.github.springweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.springweb.models.Order;

@Service
public class OrderBusinessService implements OrdersBusinessServiceInterface{

    @Override
    public void test() {
        System.err.println("OrderBusineesService is working!");
    }

    @Override
    public List<Order> getOrders() {
        
        List<Order> orders = new ArrayList<Order>();

        orders.add(new Order(0L, "000", "Tokyo summer Tour", 1200.0f, 3));
        orders.add(new Order(1L, "001", "Hokuriku winter trip", 1850.4f, 5));
        orders.add(new Order(2L, "002", "Osaka-Kyoto culinary Tour", 1600.5f, 2));
        orders.add(new Order(3L, "003", "Universal Studio Japan Tour", 210.5f, 2));
        orders.add(new Order(4L, "004", "Disneyland Tour", 200.0f, 3));
        orders.add(new Order(5L, "005", "Kansai Region Autumn Trip", 1700.0f, 4));
        orders.add(new Order(6L, "006", "Tokyo Sakura season Tour", 1500.0f, 3));
        orders.add(new Order(7L, "007", "Hokkaido Sapporo Winter Trip", 1500.0f, 2));

        return orders;
    }



}
