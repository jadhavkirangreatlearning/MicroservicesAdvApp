package com.csi.service;


import com.csi.vo.OrderDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "OrderDetailService", url = "http://localhost:9191")
public interface OrderDetailFeignClientService {

    @GetMapping("/orderdetails/findbyorderdetailid/{orderId}")
    public OrderDetail findByOrderId(@PathVariable int orderId);
}
