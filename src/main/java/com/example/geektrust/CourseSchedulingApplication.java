package com.example.geektrust;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.example.geektrust.constant.GeektrustConstant;
import com.example.geektrust.controller.CourseManagementController;




public class CourseSchedulingApplication {
	
    public static void main(String[] args) throws Exception {
    	if (args.length != GeektrustConstant.Integer_1) {
//        	CourseManagementController controller = new CourseManagementController("sample_input/input1.txt");
//        	controller.run();
            throw new FileNotFoundException(GeektrustConstant.FileNotFound);
        }
    	try {
            
            	
        	CourseManagementController controller = new CourseManagementController(args[GeektrustConstant.Integer_0]);
        	controller.run();
               
            
        } catch (IOException ex) {
        	System.out.println(ex.getMessage());
        }
    	 
      
    }
    
    
}
