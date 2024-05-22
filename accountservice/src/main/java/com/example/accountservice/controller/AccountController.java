package com.example.accountservice.controller;

import com.example.accountservice.model.Customer;
import com.example.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = accountService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new Response(201, "Customer account created", createdCustomer.getCustomerNumber()));
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable Long customerNumber) {
        Customer customer = accountService.getCustomer(customerNumber);
        return ResponseEntity.status(HttpStatus.FOUND)
            .body(new CustomerResponse(customer, 302, "Customer Account found"));
    }
}

// Response classes
class Response {
    public int transactionStatusCode;
    public String transactionStatusDescription;
    public Long customerNumber;

    public Response(int transactionStatusCode, String transactionStatusDescription, Long customerNumber) {
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
        this.customerNumber = customerNumber;
    }
}

class CustomerResponse {
    public Long customerNumber;
    public String customerName;
    public String customerMobile;
    public String customerEmail;
    public String address1;
    public String address2;
    public int transactionStatusCode;
    public String transactionStatusDescription;

    public CustomerResponse(Customer customer, int transactionStatusCode, String transactionStatusDescription) {
        this.customerNumber = customer.getCustomerNumber();
        this.customerName = customer.getCustomerName();
        this.customerMobile = customer.getCustomerMobile();
        this.customerEmail = customer.getCustomerEmail();
        this.address1 = customer.getAddress1();
        this.address2 = customer.getAddress2();
        this.transactionStatusCode = transactionStatusCode;
        this.transactionStatusDescription = transactionStatusDescription;
    }
}