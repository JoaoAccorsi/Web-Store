package com.webstore.productservice.Controller;

import com.webstore.productservice.DTO.ProductDTO;
import com.webstore.productservice.DTO.ProductRequest;
import com.webstore.productservice.Service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    public final ProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct (@RequestBody ProductRequest productRequest){
        RestTemplate restTemplate = new RestTemplate();
        String productNumber = productRequest.getProductNumber();

        ResponseEntity<ProductDTO> response = restTemplate.getForEntity(String.format("https://fakestoreapi.com/products/%s", productNumber), ProductDTO.class);
        productService.saveTheProduct(response.getBody());
        return "Product Created Successfully!";
    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getAllProducts(){
        return productService.getAllProducts();
    }
}