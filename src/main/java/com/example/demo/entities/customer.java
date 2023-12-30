package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.*;


@Entity
@Table(name="customers")
@Getter
@Setter
public class customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long id;
    @Column(name="customer_first_name", nullable = false)
    private String firstName;
    @Column(name="customer_Last_Name", nullable = false)
    private String lastName;
    @Column(name="address", nullable = false)
    private String address;
    @Column(name="postal_code")
    private String postal_code;
    @Column(name="phone", nullable = false)
    private String phone;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_Date;
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_Update;

    @ManyToOne
    @JoinColumn(name = "division_id")
    private division division;

    @OneToMany(mappedBy = "customer")
    private Set<cart> carts = new HashSet<>();

public void add(cart cart){
    if (cart != null){
        if(carts == null){
            carts = new HashSet<>();

        }
        carts.add(cart);
        cart.setCustomer(this);
    }
}
public customer(String firstName,String lastName,String address,String postal_code,String phone){
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.postal_code = postal_code;
    this.phone = phone;

}
public  customer(){

}
}
