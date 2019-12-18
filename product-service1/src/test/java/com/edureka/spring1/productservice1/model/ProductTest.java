package com.edureka.spring1.productservice1.model;

import org.junit.jupiter.api.Test;

class ProductTest {

    @Test
    public void shouldConstructUsingBuilder(){
        Product product = Product.builder()
                .id(1L)
                .name("Samsung")
                .description("Samsung9 Screen phone")
                .build();

//                = new Product();
//        product.setId(1L);
//        product.setName("Samsung");
//        product.setDescription("Samsung9 screen phone");


    }

}