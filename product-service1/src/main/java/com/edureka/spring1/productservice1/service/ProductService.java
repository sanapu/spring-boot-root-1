package com.edureka.spring1.productservice1.service;


import com.edureka.spring1.productservice1.model.Product;
import com.edureka.spring1.productservice1.model.ProductDTO;
import com.edureka.spring1.productservice1.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public boolean save(ProductDTO productDTO) {
        System.out.println("service  productDTO:  "+productDTO);
        // conver this product DTO into product DAO
        Product product = Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .build();

       // Product product = null ; // TODO convert productDTO into Product
        Product saved = productRepository.save(product);
        System.out.println("saved service:  "+saved);

        return saved !=null;

    }

    public boolean isExists(String name){
        return productRepository.findProductByName(name).isPresent();
    }

}
