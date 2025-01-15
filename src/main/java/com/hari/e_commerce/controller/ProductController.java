package com.hari.e_commerce.controller;

import com.hari.e_commerce.model.Product;
import com.hari.e_commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping("/products")
    public ResponseEntity<List<Product>>  getAllProducts() {
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK)  ;
    }


    @GetMapping("/product/{id}")
    public ResponseEntity<Product>  getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(service.getProductById(id),HttpStatus.OK) ;
    }


    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile){


        try {
            Product product1 = service.addProduct(product,imageFile);
            return new ResponseEntity<>(product1,HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}