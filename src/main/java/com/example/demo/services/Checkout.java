package com.example.demo.services;

import org.springframework.transaction.annotation.Transactional;

public interface Checkout {

    @Transactional
    PurchaseResponse placeOrder(Purchase purchase);
}
