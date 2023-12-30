package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.*;
@Entity
@Table(name="carts")
@Getter
@Setter
public class cart {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cart_Id")
    private Long id;
  @Column(name = "order_tracking_number")
    private String TrackingNumber;
  @Column(name = "package_price")
    private BigDecimal package_Price;
  @Column(name = "party_size")
    private int party_Size;
  @Enumerated(EnumType.STRING)
  @Column(name = "status")
    private statusType status;
  @ManyToOne
  @JoinColumn(name ="customer_id")
    private customer customer;
 @OneToMany(mappedBy = "cart")
    private Set<cartItem> cartitem = new HashSet<>();
 @Column(name = "create_date")
 @CreationTimestamp
    private Date create_Date;
 @Column(name = "last_update")
 @UpdateTimestamp
    private Date last_Update;

    public void add(cartItem item){
        if(item != null){
            if (cartitem == null){
                cartitem = new HashSet<>();
            }
            cartitem.add(item);
            item.setCart(this);
        }

    }

}
