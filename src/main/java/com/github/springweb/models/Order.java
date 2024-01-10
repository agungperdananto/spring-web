package com.github.springweb.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

    Long id = 0L;
    String orderNo = "";
    String  productName = "";
    float price = 0;
    int qty = 0;

}
