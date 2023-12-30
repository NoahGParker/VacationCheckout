package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
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
    @Column(name="excursion_id")
    private Long id;

    @Column(name = "excursion_title")
    private String excursion_Title;

    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "image_url")
    private String image_URL;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_Date;
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_Update;

    @ManyToOne
    @JoinColumn(name = "vacation_id", nullable = false)
    private vacation vacation;

    @ManyToMany
    @JoinTable(name = "excursion_cartitem",joinColumns = @JoinColumn(name = "excursion_id"), inverseJoinColumns = @JoinColumn(name = "cart_item_id"))
    private Set<cartItem> cartitems = new HashSet<>();


}
