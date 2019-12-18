package com.edureka.spring1.orderservice.repository;


import com.edureka.spring1.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Optional<Order> findOrderByUserId(String userId);
  //  Optional<Order> findOrderByProductDetailNameIn();
}
