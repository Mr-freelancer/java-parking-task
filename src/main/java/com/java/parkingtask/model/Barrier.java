package com.java.parkingtask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="Barriers")
public class Barrier {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="barrier_type", nullable = true)
    private String barrierType;

    @Column(name="barrier_name", nullable = true)
    private String barrierName;

    @Column(name="barrier_open", nullable = true)
    private boolean isOpen;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parking_id")
    private Parking parking;

    public void open(){
        this.isOpen = true;
        System.out.println("Barrier " + this.getBarrierName() + " is open");
    }

    public void close(){
        this.isOpen = false;
        System.out.println("Barrier " + this.getBarrierName() + " is close");
    }

    public int getId() {
        return id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Parking getParking() {
        return parking;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public void doCommand(String command) {

    }

    public String getBarrierType() {
        return barrierType;
    }

    public void setBarrierType(String barrierType) {
        this.barrierType = barrierType;
    }

    public String getBarrierName() {
        return barrierName;
    }

    public void setBarrierName(String barrierName) {
        this.barrierName = barrierName;
    }
}
