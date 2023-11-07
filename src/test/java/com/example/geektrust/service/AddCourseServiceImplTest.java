package com.example.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashMap;
import java.util.TreeMap;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.controller.CommandFactoryImpl;
import com.example.geektrust.converter.CommandConverter;
import com.example.geektrust.exception.CourseException;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.model.ScheduleCommand;


public class AddCourseServiceImplTest {
	
	
	
    CourseManagementService courseManagementService;
    ScheduleCommand command;
    
    private  TreeMap<String , CourseOffering> courses;
    private  HashMap<String,CourseOffering> registrationIdCourseMap;
    CommandConverter commandConverted = new CommandConverter();
    
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @BeforeEach
    public void setUp() throws Exception {
    	
    	
    	command = commandConverted.getCommandFromString("ADD-COURSE-OFFERING PYTHON JOHN 05062022 1 3");
    	courseManagementService = CommandFactoryImpl.getExecutor(command);
        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
        String output = systemOutRule.getLog();
        Assertions.assertNotNull(!output.trim().isEmpty());
    }

    @Test
    public void testExecute(){
        assertDoesNotThrow( ()->courseManagementService.courseManagementServiceExecuter(courses , registrationIdCourseMap , command));
    }


    @Test
    public void testSuccessMessage() throws  CourseException, Exception {
    	courseManagementService.courseManagementServiceExecuter(courses , registrationIdCourseMap , command);
    	String output = systemOutRule.getLog();
    	assertNotEquals("OFFERING-PYTHON-JOHN","");
    }

}
