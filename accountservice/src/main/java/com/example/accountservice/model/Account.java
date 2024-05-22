package com.example.accountservice.model;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountNumber;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    private double availableBalance;

    @ManyToOne
    @JoinColumn(name = "customer_number")
    private Customer customer;
}