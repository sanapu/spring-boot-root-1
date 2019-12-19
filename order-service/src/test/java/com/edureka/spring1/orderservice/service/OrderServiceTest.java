package com.edureka.spring1.orderservice.service;

import com.edureka.spring1.orderservice.model.Order;
import com.edureka.spring1.orderservice.model.OrderDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;
    @Test
    void saveOrder() {
//        Order order = Order.builder()
//                .userId("user1")
//                .quantity(2)
//                .address("address1 lanbe 1, 92122")
//                .productDetail(new Order.ProductDetail(20,"Nokia","Nokia description"))
//                .build();
//        orderService.orderRepository.save(order);
//        Order order1 = Order.builder()
//                .userId("user2")
//                .quantity(2)
//                .address("address1 lanbe 2, 92122")
//                .productDetail(Order.ProductDetail.builder().id(20).name("Nokia 1").description("Nokia 1 desc").build())
//                .build();
//        List<Order> list = new ArrayList<>();
//        list.add(order);
//        list.add(order1);

        OrderDTO order = OrderDTO.builder().address("address 1")
                .productDetails(new OrderDTO.ProductDetails(20,"Nokia","Nokia description"))
//                .productDetails(OrderDTO.ProductDetails.builder().id(20)
//                .name("samsung ").description("samsung desc").build())
                .quantity(2)
                .userId("userId1")
                .build();

        System.out.println(order.toString());
        Assertions.assertEquals(true,orderService.saveOrder(order));
       boolean val =  orderService.saveOrder(order);
        System.out.println(val);
    }
}