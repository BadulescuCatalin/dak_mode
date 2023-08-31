package com.example.DarkMode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    String model;
    String price;
    String year;
    String enginePower;
    String type;

}
