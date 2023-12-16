package com.csi.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class FallBackController {

    @GetMapping("/customerfallback")
    public ResponseEntity<String> customerFallBack() {
        return ResponseEntity.ok("Customer Service is down please wait!!!!!!!!");
    }

    @GetMapping("/productfallback")
    public ResponseEntity<String> productFallBack() {
        return ResponseEntity.ok("Product Service is down please wait!!!!!!!!");
    }

    @GetMapping("/orderdetailfallback")
    public ResponseEntity<String> orderDetailFallBack() {
        return ResponseEntity.ok("Order Detail Service is down please wait!!!!!!!!");
    }

}
