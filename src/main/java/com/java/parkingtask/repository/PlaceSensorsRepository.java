package com.java.parkingtask.repository;

import com.java.parkingtask.model.PlaceSensor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PlaceSensorsRepository extends CrudRepository<PlaceSensor,Integer> {
    PlaceSensor getById(int id);
    Set<PlaceSensor> findAll();
}
