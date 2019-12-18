package com.edureka.spring1.orderservice.model;

import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "product_order",catalog = "spring")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;
    @Column(name = "userId")
    String userId;

    @Embedded
    ProductDetail productDetail;

    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "address")
    String address;


    @Embeddable
    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    public static class ProductDetail {

        @Column(name = "code")
        Integer id;

        @Column(name = "name")
        String name;

        @Column(name = "description")
        String description;
    }
}
