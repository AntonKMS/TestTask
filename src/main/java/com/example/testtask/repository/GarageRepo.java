package com.example.testtask.repository;

import com.example.testtask.entity.GarageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface GarageRepo extends CrudRepository<GarageEntity, Long> {


}
