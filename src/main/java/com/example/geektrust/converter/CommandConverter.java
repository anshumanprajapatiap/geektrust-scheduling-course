package com.example.geektrust.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.enums.ScheduleOperation;
import com.example.geektrust.model.ScheduleCommand;

public class CommandConverter {
	

	public ScheduleCommand getCommandFromString(String command) throws Exception {
	    try {
	        List<String> commandWithArguments = parseCommandString(command);
	        ScheduleOperation operator = parseOperation(commandWithArguments.get(GeektrustConstant.Integer_0));
	        List<String> commandParams = commandWithArguments.subList(1, commandWithArguments.size());
	        return createScheduleCommand(operator, commandParams);
	    } catch (Exception e) {
	        throw new Exception(GeektrustConstant.INPUT_DATA_ERROR);
	    }
	}

	private List<String> parseCommandString(String command) {
	    return Arrays.asList(command.split(GeektrustConstant.space));
	}

	private ScheduleOperation parseOperation(String operationString) {
	    return ScheduleOperation.valueOf(GeektrustConstant.getOperationValue(operationString));
	}

	private ScheduleCommand createScheduleCommand(ScheduleOperation operator, List<String> commandParams) {
	    return new ScheduleCommand(operator, commandParams);
	}


}
