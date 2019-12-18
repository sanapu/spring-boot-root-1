package com.edureka.spring1.productservice1.repository;

import com.edureka.spring1.productservice1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductByDescription(String desc);
    Optional<Product> findProductByName(String name);

    Optional<Product> findProductByNameAndDescription(String name, String desc);

}
