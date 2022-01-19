package com.java.parkingtask.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="Parking")
public class Parking {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="parking_name")
    private String name;

    @Column(name="parking_size")
    private int size;

    @JsonManagedReference

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parking")
    Set<PlaceSensor> placeSensors = new HashSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "parking")
    Set<Barrier> barriers = new HashSet<>();

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public Set<PlaceSensor> getPlaceSensors() {
        return placeSensors;
    }

    public Set<Barrier> getBarriers() {
        return barriers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlaceSensors(Set<PlaceSensor> placeSensors) {
        this.placeSensors = placeSensors;
    }

    public void setBarriers(Set<Barrier> barriers) {
        this.barriers = barriers;
    }
}
