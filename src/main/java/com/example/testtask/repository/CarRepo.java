package com.example.testtask.repository;

import com.example.testtask.entity.CarEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends CrudRepository<CarEntity, Long> {

   @Query("Select count(c) from CarEntity c where c.garageEntity.id = :garage_id")
   Long sizeGarage(Long garage_id);

}

