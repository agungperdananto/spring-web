package com.github.springweb.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    Long id = 0L;

    @NotEmpty(message = "order number can't be null")
    @Size(min=3, message = "password length must not less than 3")
    String orderNo = "";

    @NotEmpty(message = "product name can't be null")
    @Size(min=5, message = "password length must not less than 5")
    String  productName = "";

    float price = 0;
    int qty = 0;

}
