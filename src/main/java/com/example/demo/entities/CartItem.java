package com.example.demo.entities;
import java.util.*;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="cart_items")
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @ManyToMany(mappedBy = "cartitems")
    private Set<Excursion> Excursions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "create_date")
    @CreationTimestamp
    private Date create_Date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_Update;

    public void addExcursion(Excursion excursion){
        this.Excursions.add(excursion);
        excursion.getCartitems().add(this);
    }

}
