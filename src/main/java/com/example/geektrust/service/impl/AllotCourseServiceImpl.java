package com.example.geektrust.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.exception.CourseException;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.model.Employee;
import com.example.geektrust.model.ScheduleCommand;
import com.example.geektrust.service.CourseManagementService;

public class AllotCourseServiceImpl implements CourseManagementService{

	@Override
	public void courseManagementServiceExecuter(TreeMap<String, CourseOffering> courses,
			Map<String, CourseOffering> courseRegistrations, ScheduleCommand command)
			throws Exception, CourseException {
		// TODO Auto-generated method stub
		String courseId = command.getCommandParams().get(GeektrustConstant.Integer_0);
		CourseOffering course = courses.get(courseId);
        if(course!=null){
            if(course.getRegisteredEmployees().size()<course.getMinCapacity()){
                course.setCancelled(true);
                printData(course);
            }else{
                course.setAllotted(true);
                printData(course);
            }
        }else{
            throw new Exception(GeektrustConstant.INPUT_DATA_ERROR);
        }
		
	}
	
	
	private void printData(CourseOffering course) {
	    String status = course.isCancelled() ? GeektrustConstant.COURSE_CANCELED : GeektrustConstant.CONFIRMED;
	    Map<String, Employee> sortedRegisteredEmployees = sortEmployeesByName(course.getRegisteredEmployees());

	    for (Map.Entry<String, Employee> entry : sortedRegisteredEmployees.entrySet()) {
	        printCourseDetails(entry.getKey(), entry.getValue(), course, status);
	    }
	}

	private Map<String, Employee> sortEmployeesByName(Map<String, Employee> employeeReg) {
	    Map<String, Employee> sortedRegisteredEmployees = new TreeMap<>(employeeReg);
	    return sortedRegisteredEmployees;
	}

	private void printCourseDetails(String employeeKey, Employee employee, CourseOffering course, String status) {
	    String pattern = GeektrustConstant.ddMMyyyy;
	    DateFormat df = new SimpleDateFormat(pattern);

	    System.out.println(employeeKey + GeektrustConstant.space +
	            employee.getEmployeeEmailAddress() + GeektrustConstant.space +
	            course.getCourseID() + GeektrustConstant.space +
	            course.getCourseName() + GeektrustConstant.space +
	            course.getInstructor() + GeektrustConstant.space +
	            df.format(course.getDate()) + GeektrustConstant.space +
	            status);
	}

	
    

}
