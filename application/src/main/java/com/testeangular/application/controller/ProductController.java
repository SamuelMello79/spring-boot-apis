package com.testeangular.application.controller;

import java.util.*;
import com.testeangular.application.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    // Set arraylist of the object Product
    private List<Product> productList = new ArrayList<>();
    // Set actual range of array
    private int currentId = 1;

    // POST request to add product
    @PostMapping
    public String addProduct(@RequestBody Product product) {
        product.setId(currentId);
        productList.add(product);
        currentId++;
        return "O produto " + product.getName() + " foi adicionado com sucesso!";
    }

    // PUT request to update a product
    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
       for (Product products: productList) {
           if (products.getId() == id) {
                product.setName(product.getName());
                product.setPrice(product.getPrice());
                return "O produto com ID " + id + " foi alterado com sucesso.";
           }
       }
       return "Produto com ID " + id + " não foi encontrado.";
    }

    // DELETE request to remove a product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {
        for(Product product: productList) {
            if(product.getId() == id) {
                productList.remove(id -1);
                return "O produto com ID " + id + " foi excluído com sucesso.";
            }
        }
        return "O produto com ID " + id + " não foi encontrado.";
    }

    // GET to list all the products
    @GetMapping
    public List<Product> listAllProducts(){
        return productList;
    }

    // GET {id} to search and list a product
    @GetMapping("/{id}")
    public Product searchProduct(@PathVariable int id){
        for(Product product: productList) {
            if(product.getId() == id) {
                return product;
            }
        }
        // if the product not exist then return null
        return null;
    }
}
