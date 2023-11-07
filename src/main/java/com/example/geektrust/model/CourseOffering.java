package com.example.geektrust.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.geektrust.constant.GeektrustConstant;

import lombok.Getter;
import lombok.Setter;

public class CourseOffering {
	
	@Getter
	private final String courseID;
	
	@Getter
	private final String courseName;
	
	@Getter
    private final String instructor;
	
	@Getter
    private final Date date;
	
	@Getter
    private final int minCapacity;
	
	@Getter
    private final int maxCapacity;
	
	@Getter @Setter
	private boolean isAllotted;
	
	@Getter @Setter
    private boolean isCancelled;
	
	@Getter @Setter
    private Map<String , Employee> registeredEmployees;
	

    public CourseOffering(String courseName, String instructor, Date date, int minEmployees, int maxEmployees) {
        this.courseID = GeektrustConstant.OFFERING + courseName + GeektrustConstant.HYPEN + instructor;
    	this.courseName = courseName;
        this.instructor = instructor;
        this.date = date;
        this.minCapacity = minEmployees;
        this.maxCapacity = maxEmployees;
        this.registeredEmployees = new HashMap<>();
        this.isAllotted = false;
        this.isCancelled = false;
    }


    public String addEmployee(Employee e){
        String registrationID = GeektrustConstant.REGCOURSE+e.getEmployeeName()+GeektrustConstant.HYPEN+this.courseName;
        this.registeredEmployees.put(registrationID , e);
        return registrationID;
    }
    

    public int compareTo(CourseOffering obj) {
        return this.courseName.compareTo(obj.courseName);
    }
    
   

}
