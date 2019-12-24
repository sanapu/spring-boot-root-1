package com.edureka.spring1.productservice1.resource;

import com.edureka.spring1.productservice1.model.ProductDTO;
import com.edureka.spring1.productservice1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProductResource {

    @Autowired
    ProductService productService;

    @PostMapping()
    @RequestMapping(path = "/product", produces = APPLICATION_JSON_VALUE,
    consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> saveProduct(@RequestBody  ProductDTO productDTO){
        System.out.println(" productDTO:  "+productDTO);
        boolean saved = productService.save(productDTO);
        if(!saved){
            throw new ProductCreationExceptionFailure();
        }
        System.out.println("saved:  "+saved);
        //return saved; // 201 ok staus
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }



    @GetMapping
    @RequestMapping("/test")
    public String getstring(ProductDTO productDTO){


        //return saved; // 201 ok staus
        return "Hello Product service";
    }

    @GetMapping
    @RequestMapping(path = "/product/isexist")
   // @RequestMapping("/isExist")
    public Boolean isExists(@RequestParam String name){
    System.out.println("---- "+productService.isExists(name));

        //return saved; // 201 ok staus
        return productService.isExists(name);
    }


    private class ProductCreationExceptionFailure extends RuntimeException {
    }
}
