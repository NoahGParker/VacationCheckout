package com.example.demo.services;

import org.springframework.transaction.annotation.Transactional;

public interface checkoutCustomer {

    @Transactional
    purchaseTrackingOrder placeCustomerOrder(purchaseCustomer purchase);
}
