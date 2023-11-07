package com.example.geektrust.service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.exception.CourseException;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.model.Employee;
import com.example.geektrust.model.ScheduleCommand;
import com.example.geektrust.service.impl.AllotCourseServiceImpl;

public class AllotCourseServiceImplTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    AllotCourseServiceImpl service;
    TreeMap<String, CourseOffering> courses;

    @BeforeEach
    public void setUp() throws ParseException {
        System.setOut(new PrintStream(outContent));
        service = new AllotCourseServiceImpl();
        courses = new TreeMap<>();
    }

    @Test
    public void testAllotCourse() throws CourseException, Exception {
        CourseOffering course = createCourse(true);
        courses.put(course.getCourseID(), course);

        ScheduleCommand command = new ScheduleCommand(null, Arrays.asList(course.getCourseID()));
        service.courseManagementServiceExecuter(courses, new HashMap<>(), command);

        String expectedOutput = buildExpectedOutput(course, GeektrustConstant.CONFIRMED);
        Assertions.assertEquals(expectedOutput, outContent.toString().trim());
    }

    @Test
    public void testCancelCourse() throws CourseException, Exception {
        CourseOffering course = createCourse(false);
        courses.put(course.getCourseID(), course);

        ScheduleCommand command = new ScheduleCommand(null, Arrays.asList(course.getCourseID()));
        service.courseManagementServiceExecuter(courses, new HashMap<>(), command);

        String expectedOutput = buildExpectedOutput(course, GeektrustConstant.COURSE_CANCELED);
        Assertions.assertEquals(expectedOutput, outContent.toString().trim());
    }

    private CourseOffering createCourse(boolean isAllotted) throws CourseException, ParseException {
        String courseName = "Python Course";
        String instructor = "John";
        Date date = new SimpleDateFormat("ddMMyyyy").parse("05062022");
        int minCapacity = 1;
        int maxCapacity = 3;

        CourseOffering course = new CourseOffering(courseName, instructor, date, minCapacity, maxCapacity);
        course.setAllotted(isAllotted);

        return course;
    }

    private String buildExpectedOutput(CourseOffering course, String status) {
        Map<String, Employee> registeredEmployees = course.getRegisteredEmployees();
        Map<String, Employee> sortedRegisteredEmployees = new TreeMap<>(registeredEmployees);
        List<String> outputLines = new ArrayList<>();

        for (Map.Entry<String, Employee> entry : sortedRegisteredEmployees.entrySet()) {
            String pattern = GeektrustConstant.ddMMyyyy;
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            String outputLine = entry.getKey() + " " +
                    entry.getValue().getEmployeeEmailAddress() + " " +
                    course.getCourseID() + " " +
                    course.getCourseName() + " " +
                    course.getInstructor() + " " +
                    df.format(course.getDate()) + " " +
                    status;
            outputLines.add(outputLine);
        }

        return String.join(System.lineSeparator(), outputLines);
    }
}
