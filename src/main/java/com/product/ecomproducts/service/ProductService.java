package com.product.ecomproducts.service;


import com.product.ecomproducts.dto.ProductRequest;
import com.product.ecomproducts.dto.ProductResponse;
import com.product.ecomproducts.model.Product;
import com.product.ecomproducts.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest){
        Product product=Product.builder().name(productRequest.getName()).description(productRequest.getDescription()).price(productRequest.getPrice()).build();
        productRepository.save(product);
        log.info("Product is {} added",product.getId());
    }
    public List<ProductResponse> getAllProducts(){
        List<Product> products=productRepository.findAll();
        return products.stream().map(this::mapToProduceResponse).toList();

    }

    private ProductResponse mapToProduceResponse(Product product) {
    return ProductResponse.builder().id(product.getId()).name(product.getName()).
            description(product.getDescription()).
            price(product.getPrice()).build();
    }


}
