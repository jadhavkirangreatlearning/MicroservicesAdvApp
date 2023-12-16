package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;

    @Size(min = 2, message = "Customer Name should be atleast 2 Characters")
    private String custName;

    private String custAddress;


    //@Range(min = 1000000000, max = 9999999999L, message = "Employee Contact Number must be 10 digit")
    private long empContactNumber;

    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "Asia/Kolkata")
    private Date custDOB;

    @Email(message = "Email ID must be valid")
    private String custEMailId;

    @Size(min = 4, message = "Password should be atleast 4 characters")
    private String custPassword;

    private int productId;

    private int orderId;
}
