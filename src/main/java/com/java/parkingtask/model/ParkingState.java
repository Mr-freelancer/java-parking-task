package com.java.parkingtask.model;

import org.springframework.stereotype.Component;

@Component
public class ParkingState {
    private int size;
    private int freeCarPlaces;

    public int getSize() {
        return size;
    }

    public int getFreeCarPlaces() {
        return freeCarPlaces;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFreeCarPlaces(int freeCarPlaces) {
        this.freeCarPlaces = freeCarPlaces;
    }
}
