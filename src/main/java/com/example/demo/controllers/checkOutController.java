package com.example.demo.controllers;
import com.example.demo.services.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping
public class checkOutController {
    private checkoutCustomer checkout;
    public checkOutController(checkoutCustomer checkout){
        this.checkout = checkout;
    }
    @PostMapping("/purchaseCustomer")
    public purchaseTrackingOrder placeOrder(@RequestBody purchaseCustomer purchase){
        purchaseTrackingOrder purchaseTrackingOrder = checkout.placeCustomerOrder(purchase);
        return purchaseTrackingOrder;
    }



}
