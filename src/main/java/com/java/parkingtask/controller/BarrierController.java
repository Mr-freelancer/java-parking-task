package com.java.parkingtask.controller;

import com.java.parkingtask.model.Barrier;
import com.java.parkingtask.model.CommandDTO;
import com.java.parkingtask.service.BarrierService;
import com.java.parkingtask.service.PlaceSensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/barriers")
public class BarrierController {
    private final PlaceSensorService placeSensorService;
    private final BarrierService barrierService;

    public BarrierController(PlaceSensorService placeSensorService, BarrierService barrierService) {
        this.placeSensorService = placeSensorService;
        this.barrierService = barrierService;
    }

    @PostMapping(value="/{id}")
    public ResponseEntity<?> barrierCommand(@PathVariable("id") int id, @RequestBody CommandDTO requestCommand) {
        var command = requestCommand.getCommand();

        if(!barrierService.isBarrierContain(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Barrier Not Found");
        }

        Barrier serverBarrier = barrierService.getBarrierById(id);


        if(placeSensorService.countFreePlaces() > 0 || requestCommand.getCommand().equals("close") || serverBarrier.getBarrierType().equals("out")){
            barrierService.doCommand(serverBarrier, command);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking is full");
        }
        return ResponseEntity.ok(barrierService.save(serverBarrier));
    }

    @GetMapping(value="/")
    public ResponseEntity<?> getAllBarriers(){
        return ResponseEntity.ok(barrierService.getAllBarriers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getBarrierById(@PathVariable("id") int id) {
        if(!barrierService.isBarrierContain(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Barrier Not Found");
        }
        return ResponseEntity.ok(barrierService.getBarrierById(id));
    }
}
