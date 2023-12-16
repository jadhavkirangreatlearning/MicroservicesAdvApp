package com.csi.service;

import com.csi.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "ProductService", url = "http://localhost:9192")
public interface ProductFeignClientService {

    @GetMapping("/products/findbyproductid/{productId}")
    public Product findByProductId(@PathVariable int productId);
}
