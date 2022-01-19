package com.java.parkingtask.model;

public class CommandDTO {
    private int id;
    private String command;

    public int getId() {
        return id;
    }

    public String getCommand() {
        return command;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public CommandDTO(String command) {
        this.command = command;
    }

    public CommandDTO() {

    }
}
