package com.example.testtask.mapper;

import com.example.testtask.controller.dto.CarDto;
import com.example.testtask.entity.CarEntity;
import org.springframework.stereotype.Component;

@Component
public class Mapper {


    public CarDto getCarDto(CarEntity carEntity) {
        CarDto carDto = new CarDto();
        carDto.setBrandName(carEntity.getBrandName());
        carDto.setDriverName(carEntity.getDriverName());
        return carDto;
    }
}
