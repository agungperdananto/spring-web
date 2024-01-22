package com.github.springweb.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "orders")
public class OrderEntity {

    @Id
    String id;

    @Indexed(unique=true)
    String orderNo = "";

    @Indexed(unique=true)
    String  productName = "";

    float price = 0;

    int qty = 0;
}
