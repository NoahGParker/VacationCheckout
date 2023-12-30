package com.example.demo.entities;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="countries")
@Getter
@Setter
public class country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
        private Long id;

    @Column(name = "Country")
        private String country_Name;
    @OneToMany(mappedBy = "country" , cascade = {CascadeType.ALL})
        private Set<division> divisions;
    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_Date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_Update;

}
