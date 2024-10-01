package com.testeangular.application.service;

import com.testeangular.application.model.Product;
import com.testeangular.application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updateProduct) {
        return productRepository.findById(id)
            .map(product -> {
                product.setName(updateProduct.getName());
                product.setPrice(updateProduct.getPrice());
                return productRepository.save(product);
            }
        ).orElse(null);
    }

    public boolean deleteProduct(Long id) {
        if(productRepository.existsById(id)) {
            productRepository.existsById(id);
            return true;
        }
        return false;
    }
}
