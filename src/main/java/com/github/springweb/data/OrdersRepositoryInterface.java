package com.github.springweb.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.github.springweb.models.OrderEntity;

public interface OrdersRepositoryInterface extends CrudRepository<OrderEntity, Long> {
    
    List<OrderEntity> findByProductNameContainingIgnoreCase(String keyword);

}
