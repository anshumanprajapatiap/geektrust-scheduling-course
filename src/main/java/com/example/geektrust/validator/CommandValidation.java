package com.example.geektrust.validator;

import java.util.EnumSet;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.enums.ScheduleOperation;
import com.example.geektrust.model.ScheduleCommand;


public class CommandValidation {
	
public boolean validateCommand(ScheduleCommand command) {
		
		
		if(!validateOperation(command.getInputCommand())) {
			return false;
		}
		if(!validateInputCommand(command.getInputCommand(), command)) {
			return false;
		}
		
		
		
		return true;
		
	}
	
	private boolean validateOperation(ScheduleOperation operation) {
		
		return EnumSet.allOf(ScheduleOperation.class).contains(operation);
	}
	
	
	
	private boolean validateInputCommand(ScheduleOperation inputCommand , ScheduleCommand command){
        int paramSize = command.getCommandParams().size();
        int minParamAccepted = inputCommand.getNumberOfArguments().get(GeektrustConstant.minArgs);
        int maxParamAccepted = inputCommand.getNumberOfArguments().get(GeektrustConstant.maxArgs);
		if(paramSize < minParamAccepted || paramSize > maxParamAccepted){
//			System.out.print(paramSize + " Min -> " + minParamAccepted + " Max -> " + maxParamAccepted + " ERRORAYEGA ");
            return false;
        }
		return true;
    }
}
