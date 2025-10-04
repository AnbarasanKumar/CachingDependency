package com.example.demo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

	@Autowired
    private  ProductRepository repository;

    @Cacheable("products")
    public List<Product> getAllProducts() {
    	simulateSlowService();
        return repository.findAll();
    }

    @CacheEvict(value = "products", allEntries = true)
    public Product addProduct(Product product) {
        return repository.save(product);
    }

    @CacheEvict(value = "products", allEntries = true)
    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }
    
    @CacheEvict(value = "products", allEntries = true)
    public void deleteAllProduct() {
    	repository.deleteAll();
    }
    
    private void simulateSlowService() {
        try {
            Thread.sleep(5000); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

