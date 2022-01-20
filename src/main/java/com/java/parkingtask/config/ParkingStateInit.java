package com.java.parkingtask.config;

import com.java.parkingtask.service.ParkingStateService;
import com.java.parkingtask.service.PlaceSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ParkingStateInit implements CommandLineRunner {
    private PlaceSensorService placeSensorService;
    private ParkingStateService parkingStateService;

    @Override
    public void run(String... args) throws Exception {
        parkingStateService.setFreeCarPlaces(placeSensorService.countFreePlaces());
        parkingStateService.setParkingStateSize(placeSensorService.getAllPlaceSensors().size());
    }

    @Autowired
    public void setPlaceSensorService(PlaceSensorService placeSensorService) {
        this.placeSensorService = placeSensorService;
    }

    @Autowired
    public void setParkingStateService(ParkingStateService parkingStateService) {
        this.parkingStateService = parkingStateService;
    }
}
