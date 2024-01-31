package com.webstore.productservice.Service;

import com.webstore.productservice.DTO.ProductDTO;
import com.webstore.productservice.Entity.Product;
import com.webstore.productservice.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    public final ProductRepository productRepository;

    public void saveTheProduct(ProductDTO product){

        // Create the finalProduct
        Product finalProduct = Product.builder().
                id(product.getId()).
                title(product.getTitle()).
                price(product.getPrice()).
                description(product.getDescription()).
                category(product.getCategory()).
                image(product.getImage()).
                build();

        // Persist the object into the database
        productRepository.save(finalProduct);

        // Log that the product was created [Sl4j]
        log.info("Product {} created", finalProduct.getId());
    }

    public List<ProductDTO> getAllProducts(){
        log.info("List of all the products consulted");
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream().map(product -> mapProductToProductDTO(product)).collect(Collectors.toList());
    }

    // Maps Product to productDTO
    private ProductDTO mapProductToProductDTO(Product product) {
        return ProductDTO.builder().
                id(product.getId()).
                title(product.getTitle()).
                price(product.getPrice()).
                description(product.getDescription()).
                category(product.getCategory()).
                image(product.getImage()).
                build();
    }
}