package com.example.geektrust.service;

import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.exception.CourseException;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.model.ScheduleCommand;

public interface CourseManagementService {
	
	void courseManagementServiceExecuter(TreeMap<String, CourseOffering> courses, Map<String, CourseOffering> courseRegistrations, ScheduleCommand command) throws Exception, CourseException;

}
