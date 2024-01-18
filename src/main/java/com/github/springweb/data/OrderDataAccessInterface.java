package com.github.springweb.data;

import java.util.List;


public interface OrderDataAccessInterface <T>{

    public T getbyId(long id);
    public List<T> getOrders();
    public List<T> searchOrders(String keyword);

    public long createOrder(T newOrder);

    public boolean deleteOrder(long id);

    public T updateOrder(long id, T updateOrder);
}
