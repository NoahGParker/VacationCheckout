package com.example.demo.dao;
import com.example.demo.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface cartItemRepository extends JpaRepository<CartItem,Long> {

}
