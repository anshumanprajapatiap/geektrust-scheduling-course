package com.example.geektrust.model;

import java.util.List;

import com.example.geektrust.enums.ScheduleOperation;

public class ScheduleCommand {
	
	private ScheduleOperation inputCommand;
    private List<String> commandParams;

    public ScheduleCommand(ScheduleOperation inputCommand, List<String> commandParams){
        this.inputCommand = inputCommand;
        this.commandParams = commandParams;
    }

    public ScheduleOperation getInputCommand() {
        return inputCommand;
    }

    public List<String> getCommandParams() {
        return commandParams;
    }

}
