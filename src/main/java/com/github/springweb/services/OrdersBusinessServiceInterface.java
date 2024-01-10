package com.github.springweb.services;

import java.util.List;

import com.github.springweb.models.Order;

public interface OrdersBusinessServiceInterface {
    public void test();

    public List<Order> getOrders();

    // future methods
    // SearchOrders(String search Keywords)
    // addOrder(OrderModel new)
    // deleteOrder(Long id)
    // updateOrder(Order update)
    // getOrder(Long id)

}
