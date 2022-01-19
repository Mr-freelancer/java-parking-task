package com.java.parkingtask.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="Sensors")
public class PlaceSensor {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="sensor_active", nullable = false)
    private boolean isActive;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parking_id")
    private Parking parking;

    public boolean isActive() {
        return isActive;
    }

    public int getId() {
        return id;
    }

    public Parking getParking() {
        return parking;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

}
