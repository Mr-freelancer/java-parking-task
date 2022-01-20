package com.java.parkingtask.service;

import com.java.parkingtask.model.Parking;
import com.java.parkingtask.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ParkingService {
    private ParkingRepository parkingRepository;

    @Autowired
    public void setParkingRepository(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public Set<Parking> getAllParkings() {
        return parkingRepository.findAll();
    }
}
