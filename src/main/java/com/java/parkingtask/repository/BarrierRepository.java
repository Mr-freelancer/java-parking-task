package com.java.parkingtask.repository;

import com.java.parkingtask.model.Barrier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;

@Repository
public interface BarrierRepository extends CrudRepository<Barrier, Integer> {
    Barrier getById(int id);
    Set<Barrier> findAll();
}
