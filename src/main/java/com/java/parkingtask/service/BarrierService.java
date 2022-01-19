package com.java.parkingtask.service;

import com.java.parkingtask.model.Barrier;
import com.java.parkingtask.repository.BarrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class BarrierService {
    private final BarrierRepository barrierRepository;

    public BarrierService(BarrierRepository barrierRepository) {
        this.barrierRepository = barrierRepository;
    }

    public Barrier save(Barrier barrier){
        return barrierRepository.save(barrier);
    }

    public Barrier getBarrierById(int id){
        return barrierRepository.getById(id);
    }

    public Set<Barrier> getAllBarriers() {
        return barrierRepository.findAll();
    }

    public void doCommand(Barrier serverBarrier, String command) {
        Barrier barrier = barrierRepository.getById(serverBarrier.getId());
        switch (command){
            case "open":
                barrier.open();
                break;
            case "close":
                barrier.close();
                break;
            default:
                System.out.println("Command Not Found");
        }
    }

    public boolean isBarrierContain(int id) {
        return barrierRepository.existsById(id);
    }
}
