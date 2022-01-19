package com.java.parkingtask.controller;
import com.java.parkingtask.service.PlaceSensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sensors/")
public class PlaceSensorController {
    private final PlaceSensorService placeSensorService;

    public PlaceSensorController(PlaceSensorService placeSensorService) {
        this.placeSensorService = placeSensorService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> getAllSensors(){
        return ResponseEntity.ok(placeSensorService.getAllPlaceSensors());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getPlaceSensorState(@PathVariable int id){
        if(!placeSensorService.isPlaceSensorContain(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sensor Not found");
        }
        return ResponseEntity.ok(placeSensorService.getPlaceSensorById(id));
    }
}
