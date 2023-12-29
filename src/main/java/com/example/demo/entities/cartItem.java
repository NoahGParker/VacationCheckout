package com.example.demo.entities;
import java.util.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="cart_items")
@Getter
@Setter
@ToString
public class cartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_Item_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vacation_ID")
    private vacation vacation;

    @ManyToMany(mappedBy = "cartItems")
    private Set<excursion> excursions = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cart_Id")
    private cart cart;

    @Column(name = "create_Date")
    @CreationTimestamp
    private Date create_Date;

    @Column(name = "last_update")
    @UpdateTimestamp
    private Date last_Update;

    public void addExcur(excursion excursion){
        this.excursions.add(excursion);
        excursion.getCartItems().add(this);
    }

}
