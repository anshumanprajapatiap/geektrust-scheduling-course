package com.example.geektrust.model;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.validator.PatternValidator;

import lombok.Getter;
import lombok.Setter;

public class Employee {
	
	@Getter
	private final String employeeId;
	
	@Getter
	private final String employeeName;
	
	@Getter
    private final String employeeEmailAddress;

    public Employee(String email) throws Exception {
    	
    	if (PatternValidator.validateEmailAddress(email)) {
    		String name = email.substring(0, email.indexOf(GeektrustConstant.AT_THE_RATE_SYMBOL));
    		this.employeeId = name + GeektrustConstant.HYPEN + email;
            this.employeeName = name;
            this.employeeEmailAddress = email;
        } else {
            throw new Exception(GeektrustConstant.INPUT_DATA_ERROR);
        }
    	
    	
    }

    public String getCourseRegistrationId() {
        return GeektrustConstant.REGCOURSE + employeeName + GeektrustConstant.HYPEN + employeeEmailAddress;
    }
    

}
