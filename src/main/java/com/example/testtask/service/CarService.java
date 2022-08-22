package com.example.testtask.service;

import com.example.testtask.controller.dto.CarDto;
import com.example.testtask.entity.CarEntity;
import com.example.testtask.entity.GarageEntity;
import com.example.testtask.exception.GarageIsFullException;
import com.example.testtask.exception.GarageNotFoundException;
import com.example.testtask.repository.CarRepo;
import com.example.testtask.repository.GarageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepo carRepo;
    @Autowired
    private GarageRepo garageRepo;

    @Value("${spring.garage.size}")
    Long size;


    public CarEntity newCar(CarDto carDto) throws GarageNotFoundException, GarageIsFullException {
        Long garageId = carDto.getGarageId();
        Optional<GarageEntity> optionalGarageEntity = garageRepo.findById(garageId);
        if(optionalGarageEntity.isPresent() == false){
            throw new GarageNotFoundException("Гараж с id =" + garageId + " не найден");
        }

        if (optionalGarageEntity.get().getCarsList().size()>=size){
          throw new GarageIsFullException("Гараж Заполнен");

        }
        CarEntity carEntity = new CarEntity();
        carEntity.setGarageEntity(optionalGarageEntity.get());
        carEntity.setDriverName(carDto.getDriverName());
        carEntity.setBrandName(carDto.getBrandName());


        return carRepo.save(carEntity);
    }

   public List<CarEntity> getListCar (){

        return (List<CarEntity>) carRepo.findAll();
    }

    public CarEntity findById(Long id) throws GarageNotFoundException {
       Optional<CarEntity> carEntityOpt = carRepo.findById(id);
       if (!carEntityOpt.isPresent()) {
           throw new GarageNotFoundException("Гараж не найден");
       }
       return carEntityOpt.get();
    }


}
