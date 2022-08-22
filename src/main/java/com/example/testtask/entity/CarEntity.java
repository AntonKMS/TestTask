package com.example.testtask.entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "brand")
    private String brandName;

   @ManyToOne
   @JoinColumn (name = "garage_id")
   private GarageEntity garageEntity;

    public CarEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public GarageEntity getGarageEntity() {
        return garageEntity;
    }

    public void setGarageEntity(GarageEntity garageEntity) {
        this.garageEntity = garageEntity;
    }
}
