package com.edureka.spring1.orderservice.resource;


import com.edureka.spring1.orderservice.model.OrderDTO;
import com.edureka.spring1.orderservice.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value =  "/order")
public class OrderResource {

    @Autowired
    OrderService orderService;

    @PostMapping
    @RequestMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> placeOrder(@RequestBody OrderDTO orderDTO){

        Boolean saved = orderService.saveOrder(orderDTO);
        if(!saved){
            throw new OrderException();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);

    }

    private class OrderException extends RuntimeException {
    }
}

