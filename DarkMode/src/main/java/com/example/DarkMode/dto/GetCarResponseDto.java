package com.example.DarkMode.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCarResponseDto {
    boolean darkMode;
    List<CarDto> cars;
}
