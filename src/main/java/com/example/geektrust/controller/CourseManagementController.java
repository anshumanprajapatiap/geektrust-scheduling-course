package com.example.geektrust.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.converter.CommandConverter;
import com.example.geektrust.exception.CourseException;
import com.example.geektrust.model.CourseOffering;
import com.example.geektrust.model.ScheduleCommand;
import com.example.geektrust.service.CourseManagementService;
import com.example.geektrust.service.FileService;
import com.example.geektrust.service.impl.FileInputServiceImpl;
import com.example.geektrust.validator.CommandValidation;

public class CourseManagementController {
	
    private static TreeMap<String, CourseOffering> courseOfferings;
    private static Map<String, CourseOffering> courseRegistrations;
    private final FileService fileService;
    
    CommandConverter commandConverted = new CommandConverter();
	CommandValidation commandValidation = new CommandValidation();
    
    
    
    public CourseManagementController(String filePath) throws FileNotFoundException {
    	fileService = new FileInputServiceImpl(filePath);
        courseOfferings = new TreeMap<>();
        courseRegistrations = new HashMap<>();
    }

    public void run() throws Exception {
    	List<String> commands = getCommandList();
    	for(String command: commands) {
//    		System.out.print(command + " : ");
			executeCommand(command);
		}
    	
    }
    
    
    private void executeCommand(String command) throws Exception {
    	ScheduleCommand commandModel = commandConverted.getCommandFromString(command);

	    if (commandValidation.validateCommand(commandModel)) {
	        try {
	            executeCommandService(commandModel);
	        } catch (CourseException e) {
	            handleExpenseExceptionHandler(e);
	        }
	    } else {
	        System.out.println(GeektrustConstant.INPUT_DATA_ERROR);
	    }
	}
    
    private void executeCommandService(ScheduleCommand commandModel) throws Exception {
    	CourseManagementService executionConcrete = CommandFactoryImpl.getExecutor(commandModel);
    	executionConcrete.courseManagementServiceExecuter(courseOfferings, courseRegistrations, commandModel);
	}

	private void handleExpenseExceptionHandler(CourseException e) {
	    System.out.println(e.getMessage());
	}
    
    public List<String> getCommandList() throws IOException{
		return fileService.getCommandList();
		
	}


}
