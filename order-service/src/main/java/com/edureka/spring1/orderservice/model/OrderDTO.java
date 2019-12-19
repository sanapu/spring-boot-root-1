package com.edureka.spring1.orderservice.model;


import lombok.*;

import javax.persistence.Embeddable;

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

    @Embeddable
    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    public static class ProductDetails {
        Integer id;

        String name;

        String description;
    }


}
