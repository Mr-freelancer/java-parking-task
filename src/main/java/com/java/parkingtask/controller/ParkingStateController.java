package com.java.parkingtask.controller;

import com.java.parkingtask.model.ParkingState;
import com.java.parkingtask.service.PlaceSensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/info")
public class ParkingStateController {
    private PlaceSensorService placeSensorService;
    private ParkingState parkingState;

    @GetMapping(value = "/")
    public ResponseEntity<?> getParkingInfo(){
        System.out.println(placeSensorService.countFreePlaces());
        return ResponseEntity.ok(parkingState);
    }

    @Autowired
    public void setPlaceSensorService(PlaceSensorService placeSensorService) {
        this.placeSensorService = placeSensorService;
    }

    @Autowired
    public void setParkingState(ParkingState parkingState) {
        this.parkingState = parkingState;
    }
}
