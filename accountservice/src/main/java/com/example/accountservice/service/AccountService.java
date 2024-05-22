package com.example.accountservice.service;

import com.example.accountservice.model.Account;
import com.example.accountservice.model.Customer;
import com.example.accountservice.repository.AccountRepository;
import com.example.accountservice.repository.CustomerRepository;
import com.example.accountservice.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Customer createCustomer(Customer customer) {
        if (customer.getCustomerEmail() == null || customer.getCustomerEmail().isEmpty()) {
            throw new CustomException("Email is required field", 400);
        }
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long customerNumber) {
        return customerRepository.findById(customerNumber)
            .orElseThrow(() -> new CustomException("Customer not found", 401));
    }
}