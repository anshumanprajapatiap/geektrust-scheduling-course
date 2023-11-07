package com.example.geektrust.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.model.ScheduleCommand;

public class CourseManagementControllerTest {
	
//	CourseManagementController controller = new CourseManagementController("sample_input/input1.txt");
	
	ScheduleCommand scheduleCommandInValid;


    @BeforeEach
    public void setup(){
    	scheduleCommandInValid = new ScheduleCommand(null, null);
    }
}
