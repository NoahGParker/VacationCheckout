package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="vacations")
@Getter
@Setter
@ToString
public class vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vacation_ID")
    private Long id;

    @Column(name = "vacation_Title")
    private String vacation_Title;
    @Column(name = "description")
    private String description;
    @Column(name = "travel_Fare_Price")
    private BigDecimal travel_price;
    @Column(name = "image_Url")
    private String image_Url;
    @Column(name = "create_Date")
    @CreationTimestamp
    private Date create_Date;
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_Update;
    @OneToMany(mappedBy = "vacation")
    private Set<excursion> excursions;

}
