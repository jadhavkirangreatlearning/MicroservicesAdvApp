package com.csi.controller;

import com.csi.model.Product;
import com.csi.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/saveproductdata")
    public ResponseEntity<Product> saveProductData(@RequestBody Product product){
        return ResponseEntity.ok(productServiceImpl.saveProductData(product));
    }


    @GetMapping("/findbyproductid/{productId}")
    public ResponseEntity<Optional<Product>> findByProductId(@PathVariable int productId){
        return ResponseEntity.ok(productServiceImpl.findByProductId(productId));
    }
}
