package com.example.testtask.service;

import com.example.testtask.entity.GarageEntity;
import com.example.testtask.repository.GarageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GarageService {

    @Autowired
    private GarageRepo garageRepo;

    public void newGarage(String garageName) {
        GarageEntity garageEntity = new GarageEntity();
        garageEntity.setGarageName(garageName);
        garageRepo.save(garageEntity);
    }




    public List<GarageEntity> getListGarage (){
        return (List<GarageEntity>) garageRepo.findAll();
    }

}
