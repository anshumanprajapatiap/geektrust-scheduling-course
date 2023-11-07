package com.example.geektrust.service.impl;

import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.exception.CourseException;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.model.Employee;
import com.example.geektrust.model.ScheduleCommand;
import com.example.geektrust.service.CourseManagementService;

public class RegisterCourseServiceImpl implements CourseManagementService{

	@Override
	public void courseManagementServiceExecuter(TreeMap<String, CourseOffering> courses,
			Map<String, CourseOffering> courseRegistrations, ScheduleCommand command)
			throws Exception, CourseException {
		// TODO Auto-generated method stub
		
		String courseID = command.getCommandParams().get(GeektrustConstant.Integer_1);
        Employee employee = ConstructEmployeeObject(command);
        if(courses.containsKey(courseID)){
            CourseOffering course = courses.get(courseID);
            if(isCourseEligibleForRegistration(courses, courseID)){
                if(course.getRegisteredEmployees().size()==course.getMaxCapacity()){
                    throw new CourseException(GeektrustConstant.COURSE_FULL_ERROR);
                }else{
             
                    registerEmployeeToCourse(employee , course ,courseRegistrations);
                }
            }else{
           
                System.out.println(GeektrustConstant.REGCOURSE+employee.getEmployeeName()+ GeektrustConstant.HYPEN +courses.get(courseID).getCourseName()+ GeektrustConstant.space +GeektrustConstant.REJECTED);
            }
        }else{
        
            System.out.println(GeektrustConstant.INPUT_DATA_ERROR);
        }

		
	}
	
	private boolean isCourseEligibleForRegistration(TreeMap<String, CourseOffering> courses, String courseID) {
		if(!courses.get(courseID).isAllotted() || courses.get(courseID).isCancelled()){
			return true;
		}
		
		return false;
	}
	
	
	private void registerEmployeeToCourse(Employee employee, CourseOffering course, Map<String, CourseOffering> registrationIdCourseMap) {
        String regID = course.addEmployee(employee);
        registrationIdCourseMap.put(regID , course);
        System.out.println(regID+ GeektrustConstant.space +GeektrustConstant.ACCEPTED);
    }

    private Employee ConstructEmployeeObject(ScheduleCommand command) throws Exception {
        return new Employee(command.getCommandParams().get(GeektrustConstant.Integer_0));
    }

}
