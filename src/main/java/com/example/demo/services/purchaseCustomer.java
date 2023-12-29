package com.example.demo.services;
import com.example.demo.entities.*;
import lombok.Data;

import java.util.*;
@Data
public class purchaseCustomer {
    private customer customer;
    private cart cart;
    private Set<cartItem> cartItems;
}
