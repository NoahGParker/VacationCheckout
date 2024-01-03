package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="vacations")
@Getter
@Setter
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vacation_id")
    private Long id;

    @Column(name = "vacation_title")
    private String vacation_Title;
    @Column(name = "description")
    private String description;
    @Column(name = "travel_fare_price")
    private BigDecimal travel_price;
    @Column(name = "image_url")
    private String image_URL;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_Date;
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_Update;
    @OneToMany(mappedBy = "vacation")
    private Set<Excursion> excursions;

}