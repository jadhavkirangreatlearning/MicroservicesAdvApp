package com.csi.controller;

import com.csi.model.OrderDetail;
import com.csi.service.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailController {

    @Autowired
    private OrderDetailServiceImpl orderDetailServiceImpl;

    @PostMapping("/saveorderdata")
    public ResponseEntity<OrderDetail> saveOrderData(@RequestBody OrderDetail orderDetail){
        return ResponseEntity.ok(orderDetailServiceImpl.saveOrderData(orderDetail));
    }

    @GetMapping("/findbyorderdetailid/{orderId}")
    public ResponseEntity<Optional<OrderDetail>> findByOrderId(@PathVariable int orderId){
        return ResponseEntity.ok(orderDetailServiceImpl.findByOrderId(orderId));
    }


}
