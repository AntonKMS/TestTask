package com.example.testtask.controller;


import com.example.testtask.controller.dto.CarDto;
import com.example.testtask.controller.dto.GarageDto;
import com.example.testtask.entity.CarEntity;
import com.example.testtask.entity.GarageEntity;
import com.example.testtask.mapper.Mapper;
import com.example.testtask.service.GarageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/garage")
public class GarageController {


    @Autowired
    private GarageService garageService;
    @Autowired
    Mapper mapper;

    @PostMapping
    public ResponseEntity createGarage (@RequestBody GarageDto garageDto){
        try {
            garageService.newGarage(garageDto.getGarageName());
            return ResponseEntity.ok("Гараж добавлен.");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка POST");
        }
    }
    @GetMapping
    public List<GarageDto> listGarage (){
        List<GarageEntity> listGarage = garageService.getListGarage();

        List<GarageDto> list = new ArrayList<>();
        for (GarageEntity garageEntity : listGarage) {
            List<CarDto> carsList = new ArrayList<>();
            for (CarEntity carEntity : garageEntity.getCarsList()) {
                carsList.add(mapper.getCarDto(carEntity));
            }

            GarageDto garageDto = new GarageDto();
            garageDto.setGarageName(garageEntity.getGarageName());
            garageDto.setCarsList(carsList);
            list.add(garageDto);
        }

        return list;

    }


}
