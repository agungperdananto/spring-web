package com.github.springweb;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import com.github.springweb.data.OrderDataServiceForRepository;
import com.github.springweb.data.OrderDataAccessInterface;

@Configuration
public class SpringConfig {

    @Autowired
    DataSource dataSource;


    @Bean(name="ordersDAO")
    @RequestScope
    public OrderDataAccessInterface getDataService() {
        return new OrderDataServiceForRepository(dataSource);
    }
}
