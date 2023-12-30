package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.*;
@Entity
@Table(name="divisions")
@Getter
@Setter
public class division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="division_id")
    private Long id;

    @Column(name = "division")
    private String division_Name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private country country;

    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    private Set<customer> customers;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_Date;
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_Update;
}
