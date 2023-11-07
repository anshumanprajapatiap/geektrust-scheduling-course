package com.example.geektrust.service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.exception.CourseException;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.model.Employee;
import com.example.geektrust.model.ScheduleCommand;
import com.example.geektrust.service.impl.CancelCourseServiceImpl;


public class CancelCourseServiceImplTest {
	
	 private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    private final PrintStream originalOut = System.out;

	    CancelCourseServiceImpl service;
	    TreeMap<String, CourseOffering> courses;
	    HashMap<String, CourseOffering> registrationIdCourseMap;

	    @BeforeEach
	    public void setUp() {
	        System.setOut(new PrintStream(outContent));
	        service = new CancelCourseServiceImpl();
	        courses = new TreeMap<>();
	        registrationIdCourseMap = new HashMap<>();
	    }

	    @Test
	    public void testCancelAccepted() throws CourseException, Exception {
	        CourseOffering course = createCourse(true);
	        String regId = registerEmployeeToCourse(course);

	        ScheduleCommand command = new ScheduleCommand(null, Arrays.asList(regId));
	        service.courseManagementServiceExecuter(courses, registrationIdCourseMap, command);

	        String expectedOutput = regId + " " + GeektrustConstant.CANCEL_REJECTED;
	        Assertions.assertEquals(expectedOutput, outContent.toString().trim());
	    }

	    @Test
	    public void testCancelRejectedNonAllottedCourse() throws CourseException, Exception {
	        CourseOffering course = createCourse(false);
	        String regId = registerEmployeeToCourse(course);

	        ScheduleCommand command = new ScheduleCommand(null, Arrays.asList(regId));
	        service.courseManagementServiceExecuter(courses, registrationIdCourseMap, command);

	        String expectedOutput = regId + " " + GeektrustConstant.CANCEL_ACCEPTED;
	        Assertions.assertEquals(expectedOutput, outContent.toString().trim());
	    }

	    @Test
	    public void testCancelRejectedInvalidRegistrationID() throws Exception, CourseException {
	        String regId = "INVALID_ID";

	        ScheduleCommand command = new ScheduleCommand(null, Arrays.asList(regId));
	        service.courseManagementServiceExecuter(courses, registrationIdCourseMap, command);

	        String expectedOutput = regId + " " + GeektrustConstant.CANCEL_REJECTED;
	        Assertions.assertEquals(expectedOutput, outContent.toString().trim());
	    }

	    private CourseOffering createCourse(boolean isAllotted) throws CourseException {
	        String courseId = "COURSE123";
	        String courseName = "Python Course";
	        String instructor = "John";
	        Date date = new Date();
	        int minCapacity = 1;
	        int maxCapacity = 3;

	        CourseOffering course = new CourseOffering(courseName, instructor, date, minCapacity, maxCapacity);
	        course.setAllotted(isAllotted);

	        return course;
	    }

	    private String registerEmployeeToCourse(CourseOffering course) throws CourseException, Exception {
	        String regId = course.addEmployee(new Employee("test@example.com"));
	        registrationIdCourseMap.put(regId, course);
	        return regId;
	    }
    

}
