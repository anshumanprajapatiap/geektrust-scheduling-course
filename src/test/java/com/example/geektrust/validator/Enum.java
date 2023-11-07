package com.example.geektrust.validator;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.enums.ScheduleOperation;

public class Enum {
	
	Map<String, Integer> registerValue;
	Map<String, Integer>  courseOfferingValue;

    @BeforeEach
    public void setup(){
    }
    @Test
    public void testGetNumberOfArguments() {
        assertNotEquals(Optional.of(ScheduleOperation.REGISTER.getNumberOfArguments()).get(), registerValue);
        assertNotEquals(Optional.of(ScheduleOperation.ADD_COURSE_OFFERING.getNumberOfArguments()).get(),courseOfferingValue);
    }

}
