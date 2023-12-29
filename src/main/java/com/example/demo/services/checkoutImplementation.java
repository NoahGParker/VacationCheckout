package com.example.demo.services;
import java.util.*;
import com.example.demo.entities.*;
import com.example.demo.dao.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class checkoutImplementation implements checkoutCustomer{
    private final customerRepository customerRepository;
    private final  cartRepository cartRepository;
    private final  vacationRepository vacationRepository;
    private final  excursionRepository excursionRepository;
    private final cartItemRepository cartItemRepository;

    public checkoutImplementation(customerRepository customerRepository,cartRepository cartRepository,vacationRepository vacationRepository,excursionRepository excursionRepository,cartItemRepository cartItemRepository){
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
        this.vacationRepository = vacationRepository;
        this.excursionRepository = excursionRepository;
        this.cartItemRepository = cartItemRepository;
    }
    @Override
    @Transactional
    public purchaseTrackingOrder placeCustomerOrder(purchaseCustomer purchase){
        String TrackingNumber = generateTrackingNumber();
        purchase.getCart().setTrackingNumber(TrackingNumber);
        purchase.getCart().setStatus(statusType.ordered);

        vacation vacation = purchase.getCartItems()
                .stream()
                .findFirst()
                .map(cartItem::getVacation)
                .orElseThrow(() -> new IllegalArgumentException("Vacation cannont be empty."));
        vacationRepository.save(vacation);
        cart savedCart = cartRepository.save(purchase.getCart());

        Optional.ofNullable(vacation.getExcursions()).ifPresent(excursions -> excursions.forEach(excursion -> {
            if (excursion.getVacation()==null) {
                excursion.setVacation(vacation);
            }
            excursionRepository.save(excursion);
        }));
        purchase.getCartItems().forEach(cartItem -> {
         cartItem.setCart(savedCart);
         cartItemRepository.save(cartItem);
        });
        purchase.getCartItems().forEach(cartItem ->{
            Set<excursion> excursionsForcartItem = cartItem.getExcursions();
            if(excursionsForcartItem != null){
                excursionsForcartItem.forEach(excursion ->{
                    excursion persistedExcursion = excursionRepository.findById(excursion.getId()).orElse(null);
                    if (persistedExcursion != null){
                        persistedExcursion.getCartItems().add(cartItem);
                        excursionRepository.save(persistedExcursion);
                    }


                });
            }

        });
        customer customer = purchase.getCustomer();
        customerRepository.save(customer);
        return new purchaseTrackingOrder(TrackingNumber);

        }
        private String generateTrackingNumber(){
        return UUID.randomUUID().toString();
    }
}
