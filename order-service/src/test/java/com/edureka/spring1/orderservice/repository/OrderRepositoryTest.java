package com.edureka.spring1.orderservice.repository;

import com.edureka.spring1.orderservice.model.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void shouldSaveOrder(){
        Order order = Order.builder()
                .userId("user1")
                .quantity(2)
                .address("address1 lanbe 1, 92122")
                .productDetail(new Order.ProductDetail(20,"Nokia","Nokia description"))
                .build();

       Order saved =  orderRepository.save(order);
        System.out.println(saved.toString());
        Optional<Order> opt = orderRepository.findOrderByUserId("user1");
        System.out.println(opt.toString());
       // Assertions.assertEquals();

    }

}