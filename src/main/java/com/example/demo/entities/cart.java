package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.*;
@Entity
@Table(name="carts")
@Getter
@Setter
@ToString
public class cart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "Cart_Id")
    private Long id;
  @Column(name = "Order_Tracking_Number")
    private String orderTrackingNumber;
  @Column(name = "Pack_Price")
    private BigDecimal package_Price;
  @Column(name = "Party_Size")
    private int party_Size;
  @Enumerated(EnumType.STRING)
  @Column(name = "status")
    private statusType status;
  @ManyToOne
  @JoinColumn(name ="customer_ID")
    private customer customer;
 @OneToMany(mappedBy = "cart")
    private Set<cartItem> cartItems = new HashSet<>();
 @Column(name = "create_Date")
 @CreationTimestamp
    private Date create_Date;
 @Column(name = "last_Update")
 @UpdateTimestamp
    private Date last_Update;

    public void add(cartItem item){
        if(item != null){
            if (cartItems == null){
                cartItems = new HashSet<>();
            }
            cartItems.add(item);
            item.setCart(this);
        }

    }

}
