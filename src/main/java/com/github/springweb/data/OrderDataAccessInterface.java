package com.github.springweb.data;

import java.util.List;

import com.github.springweb.models.Order;

public interface OrderDataAccessInterface {

    public Order getbyId(long id);
    public List<Order> getOrders();
    public List<Order> searchOrders(String keyword);

    public long createOrder(Order newOrder);

    public boolean deleteOrder(long id);

    public Order updateOrder(long id, Order updateOrder);
}
