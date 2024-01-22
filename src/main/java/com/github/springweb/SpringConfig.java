package com.github.springweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.github.springweb.data.OrderDataServiceForRepository;
import com.github.springweb.models.Order;
import com.github.springweb.data.OrderDataAccessInterface;

@Configuration
public class SpringConfig {


    @Bean(name="ordersDAO")
    @RequestScope
    public OrderDataAccessInterface<Order> getDataService() {
        return new OrderDataServiceForRepository();
    }
}
