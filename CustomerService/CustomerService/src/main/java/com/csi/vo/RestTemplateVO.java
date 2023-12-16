package com.csi.vo;

import com.csi.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestTemplateVO {

    private Customer customer;

    private Product product;

    private OrderDetail orderDetail;
}
