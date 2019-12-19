package com.edureka.spring1.productservice1.resource;

import com.edureka.spring1.productservice1.model.ProductDTO;
import com.edureka.spring1.productservice1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProductResource {

    @Autowired
    ProductService productService;

    @PostMapping()
    @RequestMapping(path = "/product", produces = APPLICATION_JSON_VALUE,
    consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> saveProduct(ProductDTO productDTO){
        boolean saved = productService.save(productDTO);
        if(!saved){
            throw new ProductCreationExceptionFailure();
        }

        //return saved; // 201 ok staus
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }


    @GetMapping
    @RequestMapping("/test")
    public String getstring(ProductDTO productDTO){


        //return saved; // 201 ok staus
        return "Hello Product service";
    }

    private class ProductCreationExceptionFailure extends RuntimeException {
    }
}
