package com.example.demo.entities;
import java.util.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="countries")
@Getter
@Setter
@ToString
public class country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_ID")
        private Long id;

    @Column(name = "country")
        private String country_Name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
        private Set<division> divisions;
    @Column(name = "create_Date")
    @CreationTimestamp
    private Date create_Date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_Update;

}
