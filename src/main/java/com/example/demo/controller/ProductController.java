package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
    private  ProductService productService;
   

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }


    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }


    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Deleted product with ID: " + id;
    }
    
    @DeleteMapping
    public String deleteAllProducts() {
    	productService.deleteAllProduct();
    	return "Delete All Products";
    }
}

