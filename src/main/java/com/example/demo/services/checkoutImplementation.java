package com.example.demo.services;
import java.util.*;
import com.example.demo.entities.*;
import com.example.demo.dao.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class checkoutImplementation implements Checkout {
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
    public PurchaseResponse placeOrder(Purchase purchase){
        String orderTrackingNumber = generateTrackingNumber();
        purchase.getCart().setOrderTrackingNumber(generateTrackingNumber());
        purchase.getCart().setStatus(StatusType.ordered);

        Vacation vacation = purchase.getCartItems()
                .stream()
                .findFirst()
                .map(CartItem::getVacation)
                .orElseThrow(() -> new IllegalArgumentException("Vacation cannont be empty."));
        vacationRepository.save(vacation);
        Cart savedCart = cartRepository.save(purchase.getCart());

        Optional.ofNullable(vacation.getExcursions()).ifPresent(excursions -> excursions.forEach(Excursion -> {
            if (Excursion.getVacation()==null) {
                Excursion.setVacation(vacation);
            }
            excursionRepository.save(Excursion);
        }));
        purchase.getCartItems().forEach(cartItem -> {
         cartItem.setCart(savedCart);
         cartItemRepository.save(cartItem);
        });
        purchase.getCartItems().forEach(cartItem ->{
            Set<Excursion> excursionsForcartItem = cartItem.getExcursions();
            if(excursionsForcartItem != null){
                excursionsForcartItem.forEach(Excursion ->{
                    Excursion persistedExcursion = excursionRepository.findById(Excursion.getId()).orElse(null);
                    if (persistedExcursion != null){
                        persistedExcursion.getCartitems().add(cartItem);
                        excursionRepository.save(persistedExcursion);
                    }


                });
            }

        });
        Customer customer = purchase.getCustomer();
        customerRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);

        }
        private String generateTrackingNumber(){
        return UUID.randomUUID().toString();
    }


}
