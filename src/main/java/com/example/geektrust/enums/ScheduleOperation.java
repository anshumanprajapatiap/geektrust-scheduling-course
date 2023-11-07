package com.example.geektrust.enums;

import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.constant.GeektrustConstant;

public enum ScheduleOperation {
	
	ADD_COURSE_OFFERING(GeektrustConstant.Integer_3, GeektrustConstant.Integer_5),
    CANCEL(GeektrustConstant.Integer_1),
    REGISTER(GeektrustConstant.Integer_2),
    ALLOT(GeektrustConstant.Integer_1);

	ScheduleOperation(Integer numArgs){
		this.minArgument = numArgs;
		this.maxArgument = numArgs;
    
    }
	ScheduleOperation(Integer minArgs, Integer maxArgs){
		this.minArgument = minArgs;
		this.maxArgument = maxArgs;
    }
    
    private final Integer minArgument;
    private final Integer maxArgument;

    public Map<String, Integer> getNumberOfArguments() {
    	Map<String, Integer> minMaxArgs = new HashMap<>();
    	minMaxArgs.put(GeektrustConstant.minArgs, minArgument);
    	minMaxArgs.put(GeektrustConstant.maxArgs, maxArgument);
        return minMaxArgs;
    }
}
