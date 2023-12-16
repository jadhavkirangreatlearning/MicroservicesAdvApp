package com.csi.service;

import com.csi.model.Customer;
import com.csi.repo.CustomerRepo;
import com.csi.vo.OrderDetail;
import com.csi.vo.Product;
import com.csi.vo.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl {

    @Autowired
    private CustomerRepo customerRepoImpl;

    @Autowired
    private ProductFeignClientService productFeignClientService;

    @Autowired
    private OrderDetailFeignClientService orderDetailFeignClientService;


    public Customer saveCustomerData(Customer customer) {

        return customerRepoImpl.save(customer);
    }

    public RestTemplateVO findByCustomerId(int custId) {

        RestTemplateVO restTemplateVO = new RestTemplateVO();

        Customer customer = customerRepoImpl.findById(custId).get();

        Product product = productFeignClientService.findByProductId(customer.getProductId());

        OrderDetail orderDetail = orderDetailFeignClientService.findByOrderId(customer.getOrderId());

        restTemplateVO.setCustomer(customer);
        restTemplateVO.setProduct(product);
        restTemplateVO.setOrderDetail(orderDetail);
        return restTemplateVO;

    }

    public List<Customer> findAll() {

        return customerRepoImpl.findAll();
    }
}
