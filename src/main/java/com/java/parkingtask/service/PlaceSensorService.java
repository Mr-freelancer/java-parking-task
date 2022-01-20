package com.java.parkingtask.service;

import com.java.parkingtask.model.Barrier;
import com.java.parkingtask.model.PlaceSensor;
import com.java.parkingtask.repository.PlaceSensorsRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PlaceSensorService {
    private final PlaceSensorsRepository placeSensorsRepository;

    public PlaceSensorService(PlaceSensorsRepository placeSensorsRepository) {
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
                break;
            case "off":
                serverPlaceSensor.setActive(false);
                break;
            default:
                System.out.println("Command Not Found");
        }
    }

    public PlaceSensor save(PlaceSensor serverPlaceSensor) {
        return placeSensorsRepository.save(serverPlaceSensor);
    }
}
