package com.example.testtask.controller;

import com.example.testtask.controller.dto.CarDto;
import com.example.testtask.entity.CarEntity;
import com.example.testtask.exception.GarageNotFoundException;
import com.example.testtask.mapper.Mapper;
import com.example.testtask.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;
    @Autowired
    Mapper mapper;

    @PostMapping
    public ResponseEntity createCar (@RequestBody CarDto carDto){
        try {
            if(!hasOnlyLiteral(carDto.getBrandName())) return ResponseEntity.badRequest().body("Поле brandName должно содержать только буквы");
            if(!hasOnlyLiteral(carDto.getDriverName())) return ResponseEntity.badRequest().body("Поле driveName должно содержать только буквы");
            carService.newCar(carDto);
            return ResponseEntity.ok("Машина добавлена.");
        }catch (GarageNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Гараж с id: не существует.");
        }


    }

    private boolean hasOnlyLiteral(String s) {
        return s != null && s.matches("^[a-zA-Zа-яА-Я]*$");
    }

    @GetMapping
    public List<CarDto> listCar(){
        List<CarDto> carsList = new ArrayList<>();
        for (CarEntity carEntity : carService.getListCar()) {
            carsList.add(mapper.getCarDto(carEntity));
        }

        return  carsList;
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneCar(@PathVariable Long id){
        try {
            CarEntity carEntity = carService.findById(id);
            CarDto carDto = mapper.getCarDto(carEntity);

            return ResponseEntity.ok(carDto);
        }catch (GarageNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Ошибка GET");
        }
    }


}
