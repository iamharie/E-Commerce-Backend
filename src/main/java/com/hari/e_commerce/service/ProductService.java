package com.hari.e_commerce.service;

import com.hari.e_commerce.model.Product;
import com.hari.e_commerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    public Product getProductById(int id){
        return repo.findById(id).orElse(new Product());
    }


    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {

        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return repo.save(product);


    }
}
