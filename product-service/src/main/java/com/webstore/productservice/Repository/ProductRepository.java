package com.webstore.productservice.Repository;

import com.webstore.productservice.Entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository <Product, String>{

}