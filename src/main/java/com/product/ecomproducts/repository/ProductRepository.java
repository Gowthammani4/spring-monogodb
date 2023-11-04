package com.product.ecomproducts.repository;

import com.product.ecomproducts.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
