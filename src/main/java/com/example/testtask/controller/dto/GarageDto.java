package com.example.testtask.controller.dto;

import com.example.testtask.entity.CarEntity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

public class GarageDto {
    private String garageName;
    private List<CarDto> carsList;

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public List<CarDto> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<CarDto> carsList) {
        this.carsList = carsList;
    }


}
