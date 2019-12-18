package com.edureka.spring1.productservice1.resource;

import com.edureka.spring1.productservice1.model.ProductDTO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ProductResourceTest {

    @Autowired
    ProductResource productResource;
    @Test
    void saveProduct() {
        ResponseEntity<Boolean> res =
                productResource.saveProduct(ProductDTO.builder().name("nokia").description("nokia description").build());
    System.out.println(res);
    }
}