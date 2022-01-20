package com.java.parkingtask.service;

import com.java.parkingtask.event.PlaceSensorEvent;
import com.java.parkingtask.event.PlaceSensorEventPublisher;
import com.java.parkingtask.model.PlaceSensor;
import com.java.parkingtask.repository.PlaceSensorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PlaceSensorService {
    private PlaceSensorsRepository placeSensorsRepository;
    private PlaceSensorEventPublisher sensorEventPublisher;

    @Autowired
    public void setSensorEventPublisher(PlaceSensorEventPublisher sensorEventPublisher) {
        this.sensorEventPublisher = sensorEventPublisher;
    }

    @Autowired
    public void setPlaceSensorsRepository(PlaceSensorsRepository placeSensorsRepository) {
        this.placeSensorsRepository = placeSensorsRepository;
    }

    public int countFreePlaces(){
        int freePlaces = 0;

        for (PlaceSensor placeSensor: placeSensorsRepository.findAll()) {
            if(!placeSensor.isActive()){
                freePlaces++;
            }
        }

        return freePlaces;
    }

    public Set<PlaceSensor> getAllPlaceSensors(){
        return placeSensorsRepository.findAll();
    }

    public PlaceSensor getPlaceSensorById(int id) {
        return placeSensorsRepository.getById(id);
    }

    public boolean isPlaceSensorContain(int id) {
        return placeSensorsRepository.existsById(id);
    }

    public void doCommand(PlaceSensor serverPlaceSensor, String command) {
        switch (command){
            case "on":
                serverPlaceSensor.setActive(true);
                sensorEventPublisher.publishEvent(new PlaceSensorEvent(this));
                break;
            case "off":
                serverPlaceSensor.setActive(false);
                sensorEventPublisher.publishEvent(new PlaceSensorEvent(this));
                break;
            default:
                System.out.println("Command Not Found");
        }
    }

    public PlaceSensor save(PlaceSensor serverPlaceSensor) {
        return placeSensorsRepository.save(serverPlaceSensor);
    }
}
