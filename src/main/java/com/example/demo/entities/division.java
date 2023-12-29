package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.*;
@Entity
@Table(name="divisions")
@Getter
@Setter
@ToString
public class division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="divisions_ID")
    private Long id;

    @Column(name = "division")
    private String division_Name;

    @ManyToOne
    @JoinColumn(name = "Country_ID")
    private country country;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "division")
    private Set<customer> customers;
    @Column(name = "create_Date")
    @CreationTimestamp
    private Date create_Date;
    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_Update;
}
