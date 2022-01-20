package com.java.parkingtask.service;

import com.java.parkingtask.event.PlaceSensorEvent;
import com.java.parkingtask.model.ParkingState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class ParkingStateService implements ApplicationListener<PlaceSensorEvent> {
    private ParkingState parkingState;
    private PlaceSensorService placeSensorService;

    @Autowired
    public void setParkingState(ParkingState parkingState) {
        this.parkingState = parkingState;
    }

    @Autowired
    public void setPlaceSensorService(PlaceSensorService placeSensorService) {
        this.placeSensorService = placeSensorService;
    }

    public void setFreeCarPlaces(int countFreePlaces) {
        parkingState.setFreeCarPlaces(countFreePlaces);
    }

    public void setParkingStateSize(int size) {
        parkingState.setSize(size);
    }

    @Override
    public void onApplicationEvent(PlaceSensorEvent event) {
        setFreeCarPlaces(placeSensorService.countFreePlaces());
    }
}
