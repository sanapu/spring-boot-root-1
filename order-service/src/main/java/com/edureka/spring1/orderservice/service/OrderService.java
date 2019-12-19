package com.edureka.spring1.orderservice.service;

import com.edureka.spring1.orderservice.model.Order;
import com.edureka.spring1.orderservice.model.OrderDTO;
import com.edureka.spring1.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public boolean saveOrder(OrderDTO orderDTO){
        Order order = Order.builder().quantity(orderDTO.getQuantity())
                            .address(orderDTO.getAddress())
                            .productDetail(Order.ProductDetail.builder()
                                                .id(orderDTO.getProductDetails().getId())
                                                .name(orderDTO.getProductDetails().getName())
                                                .description(orderDTO.getProductDetails().getDescription()).build())
                            .userId(orderDTO.getUserId())
                            .build();

        Order saved = orderRepository.save(order);

        return  saved!=null;
    }
}
