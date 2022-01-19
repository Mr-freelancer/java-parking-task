package com.java.parkingtask.repository;

import com.java.parkingtask.model.Parking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ParkingRepository extends CrudRepository<Parking,Integer> {
    Set<Parking> findAll();
}
