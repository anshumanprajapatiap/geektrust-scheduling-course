package com.example.geektrust.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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

public class RegisterCourseServiceImplTest {
	
	
	
	CourseManagementService courseManagementService1;
	CourseManagementService courseManagementService2;
	CourseManagementService courseManagementService3;
	CommandConverter commandConverted = new CommandConverter();
	
	ScheduleCommand command1;
	ScheduleCommand command2;
	ScheduleCommand command3;

    
    

    private TreeMap<String , CourseOffering> courses;
    private HashMap<String,CourseOffering> registrationIdCourseMap;
    
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @BeforeEach
    public void setUp() throws Exception, CourseException {
        command1 = commandConverted.getCommandFromString("ADD-COURSE-OFFERING PYTHON JOHN 05062022 1 3");
        command2 = commandConverted.getCommandFromString("REGISTER BOBY@GMAIL.COM OFFERING-PYTHON-JOHN");
        command3 = commandConverted.getCommandFromString("REGISTER WOO@GMAIL.COM OFFERING-PYTHON-JOHN");

        courseManagementService1 = CommandFactoryImpl.getExecutor(command1);
        courseManagementService2 = CommandFactoryImpl.getExecutor(command2);
        courseManagementService3 = CommandFactoryImpl.getExecutor(command3);

        courses = new TreeMap<>();
        registrationIdCourseMap = new HashMap<>();
        courseManagementService1.courseManagementServiceExecuter(courses, registrationIdCourseMap, command1);
        courseManagementService2.courseManagementServiceExecuter(courses, registrationIdCourseMap, command2);

        String output = systemOutRule.getLog();
        Assertions.assertNotNull(!output.trim().isEmpty());
    }

    @Test
    public void testExecute() {
        assertDoesNotThrow(() -> courseManagementService3.courseManagementServiceExecuter(courses, registrationIdCourseMap, command2));
    }

    @Test
    public void testExecuteCourseFull() {
        assertDoesNotThrow(() -> courseManagementService3.courseManagementServiceExecuter(courses, registrationIdCourseMap, command3));
        String output = systemOutRule.getLog();
        Assertions.assertFalse(output.contains("COURSE_FULL_ERROR"));
    }
    

}
