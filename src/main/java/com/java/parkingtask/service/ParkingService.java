package com.java.parkingtask.service;

import com.java.parkingtask.model.Parking;
import com.java.parkingtask.repository.ParkingRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ParkingService {
    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public Set<Parking> getAllParkings() {
        return parkingRepository.findAll();
    }
}
