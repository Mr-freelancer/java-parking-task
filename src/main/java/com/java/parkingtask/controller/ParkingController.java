package com.java.parkingtask.controller;

import com.java.parkingtask.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController {
    private ParkingService parkingService;

    @GetMapping(value="/parkings")
    public ResponseEntity<?> getParking(){
        return ResponseEntity.ok(parkingService.getAllParkings());
    }

    @Autowired
    public void setParkingService(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

}
