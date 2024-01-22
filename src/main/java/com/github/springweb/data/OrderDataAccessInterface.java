package com.github.springweb.data;

import java.util.List;


public interface OrderDataAccessInterface <T>{

    public T getbyId(String id);
    public List<T> getOrders();
    public List<T> searchOrders(String keyword);

    public String createOrder(T newOrder);

    public boolean deleteOrder(String id);

    public T updateOrder(String id, T updateOrder);
}
