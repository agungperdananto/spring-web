package com.github.springweb.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.github.springweb.models.Order;
import com.github.springweb.models.OrdersMapper;


public class OrdersDataService implements OrderDataAccessInterface<Order> {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Order getbyId(long id) {
        List<Order> result = jdbcTemplate.query("SELECT * FROM orders WHERE id=?", new OrdersMapper(), id);

        if (result.size() > 0){
            return result.getFirst();
        }
        return null;
    }

    @Override
    public List<Order> getOrders() {

       List<Order> results = jdbcTemplate.query("SELECT * FROM orders", new OrdersMapper());

       return results;
    }

    @Override
    public List<Order> searchOrders(String keyword) {

        List<Order> results = jdbcTemplate.query("SELECT * FROM orders WHERE product_name LIKE ?", new OrdersMapper(),"%" + keyword + "%");
        return results;
    }

    @Override
    public long createOrder(Order newOrder) {
        // long result = jdbcTemplate.update("INSERT INTO orders (order_number, product_name, price, qty) VALUES (?,?,?,?)", 
        //     newOrder.getOrderNo(),
        //     newOrder.getProductName(),
        //     newOrder.getPrice(),
        //     newOrder.getQty()
        // );

        SimpleJdbcInsert simpleInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleInsert.withTableName("orders").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("order_number", newOrder.getOrderNo());
        parameters.put("product_name", newOrder.getProductName());
        parameters.put("price", newOrder.getPrice());
        parameters.put("qty", newOrder.getQty());

        Number result = simpleInsert.executeAndReturnKey(parameters);

        return result.longValue();
    }

    @Override
    public boolean deleteOrder(long id) {
        int result = jdbcTemplate.update("DELETE FROM orders WHERE id=?", id);
        return result > 0;
    }

    @Override
    public Order updateOrder(long id, Order updateOrder) {
       
        int result = jdbcTemplate.update(
        "UPDATE orders SET order_number=?, product_name=?, price=?, qty=? WHERE id= ?",
        updateOrder.getOrderNo(),
        updateOrder.getProductName(),
        updateOrder.getPrice(),
        updateOrder.getQty(),
        id
        );

        if (result > 0){
            return updateOrder;
        }
        return null;
    }

}
