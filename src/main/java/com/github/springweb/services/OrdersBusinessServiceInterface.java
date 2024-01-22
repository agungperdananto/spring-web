package com.github.springweb.services;

import java.util.List;

import com.github.springweb.models.Order;

public interface OrdersBusinessServiceInterface {
    public void test();

    public Order getbyId(String id);
    public List<Order> getOrders();
    public List<Order> searchOrders(String keyword);

    public String createOrder(Order newOrder);

    public boolean deleteOrder(String id);

    public Order updateOrder(String id, Order updateOrder);


}
