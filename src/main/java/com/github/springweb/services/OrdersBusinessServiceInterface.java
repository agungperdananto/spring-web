package com.github.springweb.services;

import java.util.List;

import com.github.springweb.models.Order;

public interface OrdersBusinessServiceInterface {
    public void test();

    public Order getbyId(long id);
    public List<Order> getOrders();
    public List<Order> searchOrders(String keyword);

    public long createOrder(Order newOrder);

    public boolean deleteOrder(long id);

    public Order updateOrder(long id, Order updateOrder);


}
