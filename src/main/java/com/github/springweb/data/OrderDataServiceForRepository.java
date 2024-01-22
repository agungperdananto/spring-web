package com.github.springweb.data;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import com.github.springweb.models.Order;
import com.github.springweb.models.OrderEntity;


public class OrderDataServiceForRepository implements OrderDataAccessInterface<Order>{


    // data source
    @Autowired
    OrdersRepositoryInterface ordersRepository;  

    @Autowired
    OrderDataAccessInterface<Order> ordersDAO;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public Order getbyId(String id) {
        
        OrderEntity ordersEntity = ordersRepository.findById(id).orElse(null);

        // without modelMapper
        // Order orderModel = new Order(
        //     ordersEntity.getId(), 
        //     ordersEntity.getOrderNo(), 
        //     ordersEntity.getProductName(),
        //     ordersEntity.getPrice(), 
        //     ordersEntity.getQty()
        // );

        // with modelMapper
        Order orderModel = modelMapper.map(ordersEntity, Order.class);


        return orderModel;
    }

    @Override
    public List<Order> getOrders() {
        
        Iterable<OrderEntity> ordersEntity = ordersRepository.findAll();

        List<Order> ordersModel = new ArrayList<Order>();
        for(OrderEntity item: ordersEntity) {
            ordersModel.add(modelMapper.map(item, Order.class));
        }
        return ordersModel;
    }

    @Override
    public List<Order> searchOrders(String keyword) {
        Iterable<OrderEntity> orderEntities = ordersRepository.findByProductName(keyword);
        List<Order> orders = new ArrayList<Order>();

        for(OrderEntity entity: orderEntities){
            orders.add(modelMapper.map(entity, Order.class));
        }
        return orders;
    }

    @Override
    public String createOrder(Order newOrder) {
        OrderEntity orderEntity = modelMapper.map(newOrder, OrderEntity.class);
        OrderEntity result = ordersRepository.save(orderEntity);
        if (result != null) {
            return result.getId();
        }

        return null;
    }

    @Override
    public boolean deleteOrder(String id) {

        if (ordersRepository.existsById(id)){
            ordersRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Order updateOrder(String id, Order updateOrder) {
        if (ordersRepository.existsById(id)){
            updateOrder.setId(id);
            OrderEntity orderEntity = modelMapper.map(updateOrder, OrderEntity.class);
            OrderEntity result = ordersRepository.save(orderEntity);
            Order order = modelMapper.map(result, Order.class);

            return order;
        }
        return null;
    }

}
