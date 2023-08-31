package com.example.DarkMode.controller;

import com.example.DarkMode.dto.CarDto;
import com.example.DarkMode.dto.DarkModeDto;
import com.example.DarkMode.dto.GetCarResponseDto;
import com.example.DarkMode.model.Car;
import com.example.DarkMode.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping(value = "/cars")
    public ResponseEntity<GetCarResponseDto> getAllCars(@CookieValue(name = "darkMode", defaultValue = "false") String cookie) {
        List<CarDto> cars = carService.getAllDtoCars();
        return ResponseEntity.ok().header(cookie.toString()).body(GetCarResponseDto
                        .builder()
                        .cars(cars)
                        .darkMode(cookie.toString().equals("true"))
                        .build());
    }

    @PostMapping(value = "/addCar")
    public ResponseEntity<String> addCar(@RequestBody Car car) {
        Car addedCar = carService.addCar(car);
        if (addedCar != null) {
            return ResponseEntity.ok().body("Car added successfully!");
        }
        return ResponseEntity.badRequest().body("Invalid input!");
    }

    @PutMapping(value = "/dark-mode")
    public ResponseEntity<String> changeMode(@RequestBody DarkModeDto darkModeDto) {
        String darkMode = darkModeDto.isDarkMode() ? "true" : "false";
        ResponseCookie springCookie = ResponseCookie
                .from("darkMode", darkMode)
                .path("/")
                .build();
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, springCookie.toString())
                .body("Dark mode changed to " + darkMode);
    }

    @PutMapping(value = "/cookie/invalidate")
    public ResponseEntity<String> invalidateCookie() {
        ResponseCookie deleteSpringCookie = ResponseCookie
                .from("darkMode", "")
                .maxAge(0)
                .build();
        return ResponseEntity
                .ok()
                .header(HttpHeaders.SET_COOKIE, deleteSpringCookie.toString())
                .body("Cookie deleted successfully");
    }
}
