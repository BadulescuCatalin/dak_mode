package com.example.DarkMode.service;

import com.example.DarkMode.dto.CarDto;
import com.example.DarkMode.model.Car;
import com.example.DarkMode.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<CarDto> getAllDtoCars() {
        List<Car> carList = carRepository.findAll();
        List<CarDto> carDtoList = new ArrayList<>();
        for (Car car : carList) {
            carDtoList.add(new CarDto(car));
        }
        return carDtoList;
    }

    public Car addCar(Car car) {
        return carRepository.save(car);
    }
}
