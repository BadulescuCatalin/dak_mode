package com.example.DarkMode.dto;

import com.example.DarkMode.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDto {

    String name;
    String model;

    public CarDto(Car car) {
        this.name = car.getName();
        this.model = car.getModel();
    }
}
