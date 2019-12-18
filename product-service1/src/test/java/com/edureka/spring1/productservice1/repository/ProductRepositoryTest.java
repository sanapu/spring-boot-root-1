package com.edureka.spring1.productservice1.repository;

import com.edureka.spring1.productservice1.model.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void shouldSaveProduct(){
        Product product = Product.builder()
                .name("Samsung")
                .description("Samsung10 Screen phone")
                .build();
        productRepository.save(product);

        List<Product> list = productRepository.findAll();
        System.out.println(list.toString());
        Assertions.assertEquals(false,list.isEmpty());


        //assertTrue("is this called and true? ",list.stream().findFirst().get().equals(product));
    }

    @Test
    public void shouldsaveAll(){
        Product product = Product.builder()
                .name("Samsung")
                .description("Samsung11 Screen phone")
                .build();
        Product product1 = Product.builder()
                .name("Samsung")
                .description("Samsung12 Screen phone")
                .name("nokia")
                .description("nokia 1")
                .build()
                ;
        Product product3 = Product.builder()
                .name("Samsung")
                .description("Samsung13 Screen phone")
                .build();
        List<Product> list = new ArrayList<>();
        list.add(product);
        list.add(product1);
        list.add(product3);

        productRepository.saveAll(list);

        System.out.println(productRepository.findAll().toString());
        Assertions.assertEquals(list,productRepository.findAll());

        productRepository.delete(product3);
        System.out.println(productRepository.findAll().toString());

        Optional<Product> prod =  productRepository.findProductByName("Samsung");
        System.out.println(prod.toString());
    }

    @Test
    public void getAll(){
        System.out.println(productRepository.findAll().toString());
       // Assertions.assertEquals(list,productRepository.findAll());
    }
}