package com.github.springweb.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.github.springweb.models.Order;

@Repository
public class OrdersFakeDAO implements OrderDataAccessInterface{

    List<Order> orders = new ArrayList<Order>();

    public OrdersFakeDAO() {
        orders.add(new Order(0L, "000", "Tokyo summer Tour", 1200.0f, 3));
        orders.add(new Order(1L, "001", "Hokuriku winter trip", 1850.4f, 5));
        orders.add(new Order(2L, "002", "Osaka-Kyoto culinary Tour", 1600.5f, 2));
        orders.add(new Order(3L, "003", "Universal Studio Japan Tour", 210.5f, 2));
        orders.add(new Order(4L, "004", "Disneyland Tokyo Tour", 200.0f, 3));
        orders.add(new Order(5L, "005", "Kansai Region Autumn Trip", 1700.0f, 4));
        orders.add(new Order(6L, "006", "Tokyo Sakura season Tour", 1500.0f, 3));
        orders.add(new Order(7L, "007", "Hokkaido Sapporo Winter Trip", 1500.0f, 2));
    }

    @Override
    public Order getbyId(long id) {

        for (int i=0; i<orders.size(); i++){
            if (orders.get(i).getId()== id){
                return orders.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public List<Order> searchOrders(String keyword) {

        // using for loop
        // List<Order> foundItems = new ArrayList<Order>();
        // for(int i=0; i< orders.size(); i++){
        //     if (orders.get(i).getProductName().toLowerCase().contains(keyword)){
        //             foundItems.add(orders.get(i));
        //     }
        // }

        List<Order> foundItems = orders
            .stream()
            .filter(order -> order.getProductName().toLowerCase().contains(keyword.toLowerCase()))
            .collect(Collectors.toList());

        return foundItems;
    }

    @Override
    public long createOrder(Order newOrder) {

        boolean success = orders.add(newOrder);
        if (success){
            return 1;
        }
        return 0;
        
    }

    @Override
    public boolean deleteOrder(long id) {
        for (int i=0; i<orders.size(); i++){
            if (orders.get(i).getId()== id){
                orders.remove(i);
                return true;

            }
        }
       return false;
    }

    @Override
    public Order updateOrder(long id, Order updateOrder) {

        for (int i=0; i<orders.size(); i++){
            if (orders.get(i).getId()== id){
                orders.set(i, updateOrder);
                return orders.get(i);

            }
        }
        return null;
    }

}
