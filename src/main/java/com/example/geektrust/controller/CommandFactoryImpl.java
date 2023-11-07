package com.example.geektrust.controller;

import com.example.geektrust.model.ScheduleCommand;
import com.example.geektrust.service.CourseManagementService;
import com.example.geektrust.service.impl.AddCourseServiceImpl;
import com.example.geektrust.service.impl.AllotCourseServiceImpl;
import com.example.geektrust.service.impl.CancelCourseServiceImpl;
import com.example.geektrust.service.impl.RegisterCourseServiceImpl;

public class CommandFactoryImpl {
	
	public static CourseManagementService getExecutor(ScheduleCommand task) {
		CourseManagementService exe = null;
        if(task!=null){
            switch(task.getInputCommand()){
                case ADD_COURSE_OFFERING:
                	exe = new AddCourseServiceImpl();
                    break;
                case CANCEL:
                    exe = new CancelCourseServiceImpl();
                    break;
                case ALLOT:
                    exe = new AllotCourseServiceImpl();
                    break;
                case REGISTER:
                	exe = new RegisterCourseServiceImpl();
                    break;
                default:
                    break;
            }
        }
        return exe;
    }

}
