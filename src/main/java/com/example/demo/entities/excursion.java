package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name="excursions")
@Data
public class excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="excursion_ID")
    private Long id;

    @Column(name = "excursion_Title")
    private String excursion_Title;

    @Column(name = "excursion_Price")
    private BigDecimal excursion_price;

    @Column(name = "image_Url")
    private String image_Url;
    @Column(name = "create_Date")
    @CreationTimestamp
    private Date create_Date;
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_Update;

    @ManyToOne
    @JoinColumn(name = "vacation_ID", nullable = false)
    private vacation vacation;

    @ManyToMany
    @JoinTable(name = "excursion_cartitem",joinColumns = @JoinColumn(name = "excursion_ID"), inverseJoinColumns = @JoinColumn(name = "cart_Item_ID"))
    private Set<cartItem> cartItems = new HashSet<>();


}
