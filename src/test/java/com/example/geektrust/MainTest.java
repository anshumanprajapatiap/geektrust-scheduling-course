package com.example.geektrust;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
	
	
	@Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testMain() throws Exception {
        CourseSchedulingApplication.main(new String[]{"sample_input/input1.txt"});
        String output = systemOutRule.getLog();
        Assertions.assertNotNull(!output.trim().isEmpty());
    }
}