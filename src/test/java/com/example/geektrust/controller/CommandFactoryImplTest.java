package com.example.geektrust.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.converter.CommandConverter;
import com.example.geektrust.model.ScheduleCommand;
import com.example.geektrust.service.impl.AddCourseServiceImpl;
import com.example.geektrust.service.impl.AllotCourseServiceImpl;
public class CommandFactoryImplTest {
	
	 CommandConverter commandConverted = new CommandConverter();
	ScheduleCommand command;

    @BeforeEach
    public void setUp() throws Exception {
    	command = commandConverted.getCommandFromString("ADD-COURSE-OFFERING PYTHON JOHN 05062022 1 3");
    }

    @Test
    public void getExecutorTest() {
       Assertions.assertTrue(CommandFactoryImpl.getExecutor(command) instanceof AddCourseServiceImpl);
       Assertions.assertFalse(CommandFactoryImpl.getExecutor(command) instanceof AllotCourseServiceImpl);
    }

}
