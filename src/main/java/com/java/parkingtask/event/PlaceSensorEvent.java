package com.java.parkingtask.event;
import org.springframework.context.ApplicationEvent;

public class PlaceSensorEvent extends ApplicationEvent {
    public PlaceSensorEvent(Object source) {
        super(source);
    }
}
