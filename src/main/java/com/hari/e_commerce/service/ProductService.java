package com.hari.e_commerce.service;

import com.hari.e_commerce.model.Product;
import com.hari.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts(){
        List<Product> products = repo.findAll();
        System.out.println("Products: " + products);
        return products;

    }



}
