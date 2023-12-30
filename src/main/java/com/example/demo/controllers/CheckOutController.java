package com.example.demo.controllers;
import com.example.demo.services.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckOutController {
    private Checkout checkout;
    public CheckOutController(Checkout checkout){
        this.checkout = checkout;
    }
    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse PurchaseResponse = checkout.placeOrder(purchase);
        return PurchaseResponse;
    }



}
