package com.github.springweb.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;


public class OrdersMapper implements RowMapper<Order> {

    @Override
    @Nullable
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {

        Order order = new Order(
        rs.getLong("id"), 
        rs.getString("order_number"), 
        rs.getString("product_name"),
        rs.getFloat("price"), 
        rs.getInt("qty"));

        return order;
    }

}
