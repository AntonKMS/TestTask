package com.example.testtask.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "garage")
public class GarageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String garageName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "garageEntity")
    private List<CarEntity> carsList;

    public GarageEntity() {
    }

    public List<CarEntity> getCarsList() {
        return carsList;
    }

    public void setCarsList(List<CarEntity> carsList) {
        this.carsList = carsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }
}
