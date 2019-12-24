package com.edureka.spring1.productservice1.service;

import com.edureka.spring1.productservice1.model.Product;
import com.edureka.spring1.productservice1.model.ProductDTO;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;

//    Autowired
//    ProductService productService;
    @Test
    public void shouldSaveProductDTO(){
        ProductDTO product = ProductDTO.builder()
               // .id(1L)
                .name("Iphone")
                .description("Iphone Screen phone")
                .build();

        Assertions.assertEquals(true,productService.save(product));
        System.out.println(productService.productRepository.findProductByName(product.getName()));
        Optional<Product> pro = productService.productRepository.findProductByName(product.getName());

        Assertions.assertEquals(pro.get(),Product.builder()
                .id(1L)
                .name("Iphone")
                .description("Iphone Screen phone")
                .build());

    }
}