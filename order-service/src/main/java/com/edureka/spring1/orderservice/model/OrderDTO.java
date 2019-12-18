package com.edureka.spring1.orderservice.model;


import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class OrderDTO {
    String userId;

    String address;

    Integer quantity;

    ProductDetails productDetails;

    private class ProductDetails {
        Integer id;

        String name;

        String description;
    }


}
