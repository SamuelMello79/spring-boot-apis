package com.testeangular.application.controller;

import java.util.*;
import com.testeangular.application.model.Product;
import com.testeangular.application.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // GET api/products
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    // GET api/products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = productService.getProductById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    // POST api/products
    @PostMapping
    public Product addProduct (@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // PUT api/products/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updateProduct) {
       Product product = productService.updateProduct(id, updateProduct);
       return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    // DELETE api/products/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProduct(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
