package com.example.geektrust.service.impl;

import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.exception.CourseException;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.model.ScheduleCommand;
import com.example.geektrust.service.CourseManagementService;

public class CancelCourseServiceImpl implements CourseManagementService{

	@Override
	public void courseManagementServiceExecuter(TreeMap<String, CourseOffering> courses,
	        Map<String, CourseOffering> courseRegistrations, ScheduleCommand command)
	        throws Exception, CourseException {
	    String regId = command.getCommandParams().get(GeektrustConstant.Integer_0);
	    if (isValidRegistrationID(regId, courseRegistrations)) {
	        if (isCourseNotAllotted(regId, courseRegistrations)) {
	            handleCancelRejected(regId);
	        } else {
	            handleCancelAccepted(regId, courseRegistrations);
	        }
	    } else {
	        handleCancelRejected(regId);
	    }
	}

	private void handleCancelRejected(String regId) {
	    System.out.println(regId + GeektrustConstant.space + GeektrustConstant.CANCEL_REJECTED);
	}

	private void handleCancelAccepted(String regId, Map<String, CourseOffering> courseRegistrations) {
	    removeRegisteredEmployee(regId, courseRegistrations);
	    System.out.println(regId + GeektrustConstant.space + GeektrustConstant.CANCEL_ACCEPTED);
	}

	private void removeRegisteredEmployee(String regId, Map<String, CourseOffering> registrationIdCourseMap) {
	    CourseOffering course = registrationIdCourseMap.get(regId);
	    course.getRegisteredEmployees().remove(regId);
	    registrationIdCourseMap.remove(regId);
	}

	private boolean isCourseNotAllotted(String regId, Map<String, CourseOffering> registrationIdCourseMap) {
	    return registrationIdCourseMap.get(regId).isAllotted();
	}

	private boolean isValidRegistrationID(String regId, Map<String, CourseOffering> registrationIdCourseMap) {
	    return registrationIdCourseMap.containsKey(regId);
	}


}
