package com.example.geektrust.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.exception.CourseException;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.model.ScheduleCommand;
import com.example.geektrust.service.CourseManagementService;

public class AddCourseServiceImpl implements CourseManagementService{

	@Override
	public void courseManagementServiceExecuter(TreeMap<String, CourseOffering> courses,
			Map<String, CourseOffering> courseRegistrations, ScheduleCommand command)
			throws Exception, CourseException {
		// TODO Auto-generated method stub
		List<String> params = command.getCommandParams();
        CourseOffering course = constructCourseObject(params);
        addCourse(courses , course);
		
	}
	
	
	private CourseOffering constructCourseObject(List<String> params) throws Exception {
		CourseOffering course = null;
        try{
            String courseName = params.get(0);
            String courseInstructor = params.get(1);
            SimpleDateFormat inputFormat = new SimpleDateFormat(GeektrustConstant.ddMMyyyy);
            Date dateTime = inputFormat.parse(params.get(GeektrustConstant.Integer_2));
            int minCount = Integer.parseInt(params.get(GeektrustConstant.Integer_3));
            int maxCount = Integer.parseInt(params.get(GeektrustConstant.Integer_4));
            course = new CourseOffering(courseName , courseInstructor , dateTime ,minCount , maxCount);
        }catch (Exception e){
            throw new Exception(GeektrustConstant.INPUT_DATA_ERROR);
        }
        return course;
    }

    private void addCourse(Map<String, CourseOffering> courses, CourseOffering course){
        courses.put(course.getCourseID(),course);
        System.out.println(course.getCourseID());
    }
	

}
