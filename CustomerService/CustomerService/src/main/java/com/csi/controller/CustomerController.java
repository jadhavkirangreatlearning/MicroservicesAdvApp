package com.csi.controller;

import com.csi.model.Customer;
import com.csi.service.CustomerServiceImpl;
import com.csi.vo.RestTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping("/savecustomerdata")
    public ResponseEntity<Customer> saveCustomerData(@Valid @RequestBody Customer customer) {

        log.info("###########Trying to save Data for Customer: "+ customer.getCustName());
        return new ResponseEntity<>(customerServiceImpl.saveCustomerData(customer), HttpStatus.CREATED);
    }

    @GetMapping("/findbycustomerid/{custId}")
    public ResponseEntity<RestTemplateVO> findByCustomerId(@PathVariable int custId) {
        return ResponseEntity.ok(customerServiceImpl.findByCustomerId(custId));
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerServiceImpl.findAll());
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Customer>> sortByName() {
        return ResponseEntity.ok(customerServiceImpl.findAll().stream().sorted(Comparator.comparing(Customer::getCustName)).toList());
    }


}
