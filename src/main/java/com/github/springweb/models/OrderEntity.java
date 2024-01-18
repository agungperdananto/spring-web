package com.github.springweb.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @Column("id")
    int id = 0;

    @Column("order_number")
    String orderNo = "";

    @Column("product_name")
    String  productName = "";

    @Column("price")
    float price = 0;

    @Column("qty")
    int qty = 0;
}
